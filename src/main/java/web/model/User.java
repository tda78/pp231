package web.model;

public class User {
    private long id;
    private String mail;
    private String pass;
    private byte age;

    public User(long id, String mail, String pass, byte age) {
        this.id = id;
        this.mail = mail;
        this.pass = pass;
        this.age = age;
    }

    public User() {
    }

    public User(String mail, String pass, byte age) {
        this.mail = mail;
        this.pass = pass;
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
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }
}
