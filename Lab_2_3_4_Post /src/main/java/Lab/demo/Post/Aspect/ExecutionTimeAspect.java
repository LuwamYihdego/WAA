package Lab.demo.Post.Aspect;

import Lab.demo.Post.domain.Logger;
import Lab.demo.Post.domain.MyException;
import Lab.demo.Post.domain.User;
import Lab.demo.Post.repository.ExceptionRepo;
import Lab.demo.Post.repository.LoggerRepo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
public class ExecutionTimeAspect {
    @Autowired
    LoggerRepo loggerRepo;

    @Autowired
    ExceptionRepo exceptionRepo;

    @Pointcut("@annotation(Lab.demo.Post.Aspect.ExecutionTime)")
    public void executionTimeAnnotation() {
    }

    @Around("executionTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint){
        long start = System.nanoTime();
        Object result = null;
        try{
            result = proceedingJoinPoint.proceed();
            Object[] id = proceedingJoinPoint.getArgs();
            long finish = System.nanoTime();
            System.out.println(proceedingJoinPoint.getSignature().getName() + " takes: " + (finish - start) + " ns");
            Logger logger = new Logger((long)id[0], LocalDate.now(), (int)(finish - start), User.principle, proceedingJoinPoint.getSignature().getName());
            loggerRepo.save(logger);
        }
        catch(Throwable t){
            Object[] id = proceedingJoinPoint.getArgs();
            long finish = System.nanoTime();
          //  MyException exception = new MyException((long)id[0], LocalDate.now(),(int)(finish-start),User.principle, proceedingJoinPoint.getSignature().getName(), t.getClass().getSimpleName());
           // exceptionRepo.save(exception);
        }
        return result;
    }
}
