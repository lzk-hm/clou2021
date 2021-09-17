package com.lzk.springcloud.lb.lbimpl;

import com.lzk.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 13997
 */
@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        for (; ; ){
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
            if (atomicInteger.compareAndSet(current, next)) {
                return next;
            }
        }
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
