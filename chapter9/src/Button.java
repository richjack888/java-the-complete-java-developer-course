public class Button {
    private String title;
    private IOnClickListener IOnClickListener;

    public Button(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOnClickListener(IOnClickListener IOnClickListener) {
        this.IOnClickListener = IOnClickListener;
    }

    public void onClick() {
        this.IOnClickListener.onClick(this.title);
    }

    public interface IOnClickListener {
        public void onClick(String title);
    }
}
