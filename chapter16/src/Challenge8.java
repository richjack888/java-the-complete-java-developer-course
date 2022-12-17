import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Challenge8 {
    public static void main(String[] args) {

        Tutor tutor = new Tutor();
        Student student = new Student(tutor);
        tutor.setStudent(student);

        Thread tutorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    tutor.studyTime();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread studentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    student.handInAssignment();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        tutorThread.start();
        studentThread.start();
    }
}

class Tutor {
    private Student student;
    private Lock lock;

    public Tutor() {
        this.lock = new ReentrantLock();
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void studyTime() throws InterruptedException {
        System.out.println("Tutor has arrived");
        if (lock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                try {
                    // wait for student to arrive and hand in assignment
                    Thread.sleep(300);
                } catch (InterruptedException ignored) {
                }
                student.startStudy();
                System.out.println("Tutor is studying with student");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Something went wrong!" + new Object() {
            }.getClass().getEnclosingMethod().getName());
        }


    }

    public boolean getProgressReport() throws InterruptedException {
        // get progress report
        if (lock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                System.out.println("Tutor gave progress report");
                return true;
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Something went wrong!" + new Object() {
            }.getClass().getEnclosingMethod().getName());
            while (!getProgressReport()) {
                continue;
            }
        }
        return false;

    }
}

class Student {
    private Tutor tutor;
    private Lock lock;

    Student(Tutor tutor) {
        this.tutor = tutor;
        this.lock = new ReentrantLock();
    }

    public void startStudy() throws InterruptedException {
        // study
        if (lock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                System.out.println("Student is studying");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Something went wrong!" + new Object() {
            }.getClass().getEnclosingMethod().getName());
        }
    }

    public void handInAssignment() throws InterruptedException {
        if (lock.tryLock(1, TimeUnit.SECONDS)) {
            try {
                tutor.getProgressReport();
                System.out.println("Student handed in assignment");
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println("Something went wrong!" + new Object() {
            }.getClass().getEnclosingMethod().getName());
        }

    }

}
