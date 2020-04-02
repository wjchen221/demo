package com.wjchen.demo.schedule;


import com.wjchen.demo.common.utils.SpringUtil;
import com.wjchen.demo.model.Info;
import com.wjchen.demo.service.InfoService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


@Configuration
@EnableScheduling
public class DynamicScheduleTask implements SchedulingConfigurer {

    final static Logger LOGGER = LoggerFactory.getLogger(DynamicScheduleTask.class);

    @Autowired
    private InfoService infoService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                ()->LOGGER.info("=====执行动态定时任务====="),
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    Info as = null;
                    try {
//                        as = infoService.findOne("1");
                        //ceshi
                        try {
                            Object bean = SpringUtil.getBean("userService");
                            Class c = bean.getClass();
                            Object[] values = new Object[1];
                            Class[] types = new Class[1];
                            values[0] = "zhangsan";
                            types[0] = String.class;
                            Method method = c.getMethod("findByUsername", types);
                            Object resultData = method.invoke(bean, values);
                            LOGGER.info(resultData.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }catch (Exception e){
//                        as = new Info();
                    }
                    //2.2 合法性校验.
//                    if(as.getCorn() == null){
//                        as.setCorn("0 0 0 1/1 * ?");
//                    }
                    //2.3 返回执行周期(Date)
//                    return new CronTrigger(as.getCorn()).nextExecutionTime(triggerContext);
                    return new CronTrigger("0 0 0 1/1 * ?").nextExecutionTime(triggerContext);
                }
        );
   /*     try {
            List<Class<?>> taskClassList = classScanner.getClassListBySuper("com.zzxypm.schedule", AbstractTask.class);
            if (CollectionUtils.isNotEmpty(taskClassList)) {
                List<TriggerTask> taskList = new ArrayList<>(taskClassList.size());
                TriggerTask task = null;
                for (Class<?> cls : taskClassList) {
                    AbstractTask abstractTask = (AbstractTask) cls.newInstance();
                    String cron = abstractTask.getCron();
                    task = new TriggerTask((AbstractTask) cls.newInstance(),
                            triggerContext -> new CronTrigger(cron).nextExecutionTime(triggerContext)
                    );
                    taskList.add(task);
                }
                taskRegistrar.setTriggerTasksList(taskList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
