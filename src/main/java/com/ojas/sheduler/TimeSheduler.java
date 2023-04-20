package com.ojas.sheduler;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import com.ojas.configure.BookListPdf;
import com.ojas.configure.Mail;
import com.ojas.model.Book;
import com.ojas.service.BookServiceImpl;

@Configuration

@EnableScheduling

public class TimeSheduler implements SchedulingConfigurer, Runnable {
	@Autowired
	private BookServiceImpl serviceImpl;

	@Override
	public void run() {
		List<Book> allBooks = serviceImpl.findAllBooks();
		String genetatePdf = BookListPdf.genetatePdf(allBooks);
		String cc = "mallikabmd@gmail.com,pendyalajashwanth07@gmail.com,kalyansp12@gmail.com,gdivya1232@gmail.com,myself.jbk@gmail.com";
		boolean emailSend = Mail.emailSend("siva.yannam@ojas-it.com", cc, genetatePdf);
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		Trigger trigger = new Trigger() {

			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {

				CronTrigger crontrigger = new CronTrigger("0 0/1 * * * *");

				return crontrigger.nextExecutionTime(triggerContext);
			}

		};

		taskRegistrar.addTriggerTask(this::run, trigger);

	}

}
