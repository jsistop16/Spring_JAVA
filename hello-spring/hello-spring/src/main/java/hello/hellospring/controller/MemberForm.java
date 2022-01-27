package hello.hellospring.controller;

public class MemberForm {
    private String name;
    //createMemberForm.html에 있는 name="name"(입력)값에서 가져옴

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
