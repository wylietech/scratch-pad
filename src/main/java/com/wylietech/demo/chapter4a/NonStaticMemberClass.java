package com.wylietech.demo.chapter4a;

public class NonStaticMemberClass {

  private final String name;
  private final MemberClass member;

  public NonStaticMemberClass(String name) {
    this.name = name;
    member = new MemberClass();
  }

  public void askMemberToWriteName() {
    member.writeName();
  }

  private class MemberClass {
    private void writeName() {
      System.out.println(NonStaticMemberClass.this.name);
    }
  }
}
