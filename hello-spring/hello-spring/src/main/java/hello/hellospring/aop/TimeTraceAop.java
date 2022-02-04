package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect//AOP
@Component
public class TimeTraceAop {

    @Around("execution(* hello.hellospring..*(..))")//hello.hellospring패키지 하위 파일 전부
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString());
        try{
//            Object result = joinPoint.proceed();//다음메소드로 넘어감
//            return result;
            return joinPoint.proceed();//인라인 적용(다음메소드로 넘어감)
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
