package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutoWiredTest {


    @Test
    void AutoWiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false) // 의존관계가 없으면 호출이 안됨
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1: " + noBean1);
        }


        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2: " + noBean2);
        }


        @Autowired
        public void setNoBean3(Optional<Member> noBean3) {
            System.out.println("noBean3: " + noBean3);
        }
    }

}
