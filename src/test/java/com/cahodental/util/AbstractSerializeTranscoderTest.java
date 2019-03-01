package com.cahodental.util;

import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * Created by renhongjiang on 2019/3/1.
 */
public class AbstractSerializeTranscoderTest implements Serializable {


    private static final long serialVersionUID = -5661476785845730471L;


    @Test
    public void testObject() {
        // object
        List<TestUser> users = buildTestData();
        TestUser userA = users.get(1);
        ObjectTranscoder<TestUser> objectTranscoder = new ObjectTranscoder<>();
        byte[] bytes = objectTranscoder.serialize(userA);
        TestUser testUser = objectTranscoder.deserialize(bytes);
        System.out.println("testUser = " + testUser);
        System.out.println("userA = " + userA);
        System.out.print("testUser == userA : ");
        System.out.println(testUser == userA);
    }


    @Test
//    @SuppressWarnings("unchecked")
    public void testList() {
        List<TestUser> users = buildTestData();
        ListTranscoder listTranscoder = new ListTranscoder();
        byte[] bytes = listTranscoder.serialize(users);
        List<TestUser> list = listTranscoder.deserialize(bytes);
        System.out.println("list = " + list);
        int i = 0;
        for (TestUser user : list) {
            i++;
            System.out.println("user" + i + " = " + user);
        }

    }


    private List<TestUser> buildTestData() {
        /*AbstractSerializeTranscoderTest test = new AbstractSerializeTranscoderTest();
        test.new TestUser();*/
        TestUser userA = new TestUser();
        userA.setAge(26);
        userA.setName("Kevin");
        TestUser userB = new TestUser();
        userB.setAge(22);
        userB.setName("Rose");
        List<TestUser> list = new ArrayList<>();
        list.add(userA);
        list.add(userB);
        return list;
    }

    private class TestUser implements Serializable {

        private static final long serialVersionUID = 6703470570211190101L;

        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "TestUser{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}