package web.model;

public class User {
    private static int count = 0;
    private long id;
    private String mail;
    private String password;
    private byte age;

    public User(long id, String mail, String pass, byte age) {
        this.id = id;
        this.mail = mail;
        this.password = pass;
        this.age = age;
    }

    public User() {
        this.id = ++count;
    }

    public User(String mail, String pass, byte age) {
       // this.id = ++count;
        this.mail = mail;
        this.password = pass;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = pass;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }
}
