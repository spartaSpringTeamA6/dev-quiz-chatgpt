package org.example.devquizbatch.schedulers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
@Slf4j
public class SaveRDBMSScheduler {

	private final JobLauncher jobLauncher;

	@Qualifier("saveQuizAtRDBMSJob")
	private final Job saveQuizAtRDBMSJob;

	@Scheduled(cron = "0 0 8 * * *")

	public void saveQuizAtRDBMSJobSchedule() {
		try {
			jobLauncher.run(
				saveQuizAtRDBMSJob,
				new JobParametersBuilder()
					.addString("jobName", "saveQuizAtRDBMSJob")
					.addString("datetime", LocalDateTime.now().toString())
					.toJobParameters()
			);
		} catch (JobExecutionException ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
}
