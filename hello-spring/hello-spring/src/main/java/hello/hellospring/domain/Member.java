package hello.hellospring.domain;

public class Member {
    private Long id; //회원가입시 시스템이 부여해주는 값
    private String name; //회원가입시 회원이 정하는 이름

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
