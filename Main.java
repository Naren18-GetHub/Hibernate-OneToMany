package main;

import beans.Answer;
import beans.Question;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.hibernate.query.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Question q1 = new Question();
        q1.setQ_id(1212);
        q1.setQuestion("what is java");

        Answer ans1 = new Answer();
        ans1.setA_id(111);
        ans1.setAnswer("java is a programing language");


        Answer ans2 = new Answer();
        ans2.setA_id(222);
        ans2.setAnswer("java is used in backend");

        Answer ans3 = new Answer();
        ans3.setA_id(333);
        ans3.setAnswer("java is uses oops concept");

        List<Answer> answerList = new ArrayList<>();
        answerList.add(ans1);
        answerList.add(ans2);
        answerList.add(ans3);
        q1.setAnswerList(answerList);

        Session session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

//        session.save(q1);
//        session.save(ans1);
//        session.save(ans2);
//        session.save(ans3);
//
//        Question question = session.get(Question.class, 1212);
//        System.out.println(question.getQuestion());
////        System.out.println(question.getAnswerList());
//        for(Answer a = question.getAnswerList()){
//            System.out.println(a.getAnswer());
//        }

//        tx.commit();


        String query = "SELECT q.question, a.answer FROM Question AS q INNER JOIN q.answer AS a";
        Query q = (Query) session.createQuery(query);

        List<Object[]> list = q.list();

        for (Object[] obj : list){
            System.out.println(Arrays.toString(obj));
        }
    }
}