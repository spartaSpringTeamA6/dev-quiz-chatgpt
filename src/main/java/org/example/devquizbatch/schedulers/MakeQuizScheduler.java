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
public class MakeQuizScheduler {

	private final JobLauncher jobLauncher;
	@Qualifier("makeJavaQuizJob")
	private final Job makeJavaQuizJob;

	@Qualifier("makeDatabaseQuizJob")
	private final Job makeDatabaseQuizJob;

	@Qualifier("makeSpringQuizJob")
	private final Job makeSpringQuizJob;

	@Qualifier("makeNetworkQuizJob")
	private final Job makeNetworkQuizJob;

	@Qualifier("makeJavaScriptQuizJob")
	private final Job makeJavaScriptQuizJob;

	@Qualifier("makePythonQuizJob")
	private final Job makePythonQuizJob;

	@Qualifier("makeCQuizJob")
	private final Job makeCQuizJob;

	@Qualifier("makeReactQuizJob")
	private final Job makeReactQuizJob;

	@Qualifier("makeLinuxQuizJob")
	private final Job makeLinuxQuizJob;

	@Qualifier("makeJPAQuizJob")
	private final Job makeJPAQuizJob;

	@Qualifier("makeDjangoQuizJob")
	private final Job makeDjangoQuizJob;

	@Qualifier("makeComputerScienceQuizJob")
	private final Job makeComputerScienceQuizJob;

	@Scheduled(cron = "0 1/15 20 * * *")
	public void makeComputerScienceQuizJobSchedule() {
		try {
			jobLauncher.run(
					makeComputerScienceQuizJob,
					new JobParametersBuilder()
							.addString("jobName", "makeComputerScienceQuizJob")
							.addString("datetime", LocalDateTime.now().toString())
							.toJobParameters()
			);
		} catch (JobExecutionException ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
	@Scheduled(cron = "0 1/25 21 * * *")
	public void makeJavaQuizJobSchedule() {
		try {
			jobLauncher.run(
				makeJavaQuizJob,
				new JobParametersBuilder()
					.addString("jobName", "makeJavaQuizJob")
					.addString("datetime", LocalDateTime.now().toString())
					.toJobParameters()
			);
		} catch (JobExecutionException ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
	@Scheduled(cron = "0 1/15 22 * * *")
	public void makeSpringQuizJobSchedule() {
		try {
			jobLauncher.run(
					makeSpringQuizJob,
					new JobParametersBuilder()
							.addString("jobName", "makeSpringQuizJob")
							.addString("datetime", LocalDateTime.now().toString())
							.toJobParameters()
			);
		} catch (JobExecutionException ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
	@Scheduled(cron = "0 1/25 23 * * *")
	public void makePythonQuizJobSchedule() {
		try {
			jobLauncher.run(
					makePythonQuizJob,
					new JobParametersBuilder()
							.addString("jobName", "makePythonQuizJob")
							.addString("datetime", LocalDateTime.now().toString())
							.toJobParameters()
			);
		} catch (JobExecutionException ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
	@Scheduled(cron = "0 1/15 0 * * *")
	public void makeDjangoQuizJobSchedule() {
		try {
			jobLauncher.run(
					makeDjangoQuizJob,
					new JobParametersBuilder()
							.addString("jobName", "makeDjangoQuizJob")
							.addString("datetime", LocalDateTime.now().toString())
							.toJobParameters()
			);
		} catch (JobExecutionException ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
	@Scheduled(cron = "0 1/25 1 * * *")
	public void makeCQuizJobSchedule() {
		try {
			jobLauncher.run(
					makeCQuizJob,
					new JobParametersBuilder()
							.addString("jobName", "makeCQuizJob")
							.addString("datetime", LocalDateTime.now().toString())
							.toJobParameters()
			);
		} catch (JobExecutionException ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
	@Scheduled(cron = "0 1/15 2 * * *")
	public void makeJavaScriptQuizJobSchedule() {
		try {
			jobLauncher.run(
					makeJavaScriptQuizJob,
					new JobParametersBuilder()
							.addString("jobName", "makeJavaScriptQuizJob")
							.addString("datetime", LocalDateTime.now().toString())
							.toJobParameters()
			);
		} catch (JobExecutionException ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
	@Scheduled(cron = "0 1/25 3 * * *")
	public void makeReactQuizJobSchedule() {
		try {
			jobLauncher.run(
					makeReactQuizJob,
					new JobParametersBuilder()
							.addString("jobName", "makeReactQuizJob")
							.addString("datetime", LocalDateTime.now().toString())
							.toJobParameters()
			);
		} catch (JobExecutionException ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
	@Scheduled(cron = "0 1/15 4 * * *")
	public void makeJPAQuizJobSchedule() {
		try {
			jobLauncher.run(
					makeJPAQuizJob,
					new JobParametersBuilder()
							.addString("jobName", "makeJPAQuizJob")
							.addString("datetime", LocalDateTime.now().toString())
							.toJobParameters()
			);
		} catch (JobExecutionException ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
	@Scheduled(cron = "0 1/25 5 * * *")
	public void makeDatabaseQuizJobSchedule() {
		try {
			jobLauncher.run(
				makeDatabaseQuizJob,
				new JobParametersBuilder()
					.addString("jobName", "makeDatabaseQuizJob")
					.addString("datetime", LocalDateTime.now().toString())
					.toJobParameters()
			);
		} catch (JobExecutionException ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
	@Scheduled(cron = "0 1/15 6 * * *")
	public void makeNetworkQuizJobSchedule() {
		try {
			jobLauncher.run(
				makeNetworkQuizJob,
				new JobParametersBuilder()
					.addString("jobName", "makeNetworkQuizJob")
					.addString("datetime", LocalDateTime.now().toString())
					.toJobParameters()
			);
		} catch (JobExecutionException ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
	@Scheduled(cron = "0 1/15 7 * * *")
	public void makeLinuxQuizJobSchedule() {
		try {
			jobLauncher.run(
					makeLinuxQuizJob,
					new JobParametersBuilder()
							.addString("jobName", "makeLinuxQuizJob")
							.addString("datetime", LocalDateTime.now().toString())
							.toJobParameters()
			);
		} catch (JobExecutionException ex) {
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
}
