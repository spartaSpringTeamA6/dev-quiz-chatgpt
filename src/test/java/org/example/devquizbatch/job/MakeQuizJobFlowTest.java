package org.example.devquizbatch.job;

import org.example.devquizbatch.config.util.MakeQuizJobFlow;
import org.example.devquizbatch.tasklets.makequiz.step1apirequest.CategoryTitle;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class MakeQuizJobFlowTest {

    @Mock
    JobBuilderFactory jobBuilderFactory;

    @Mock
    private Step apiRequestStep;

    @Mock
    private Step converterFromResponseStep;

    @Mock
    private Step categoryMapperStep;


    public MakeQuizJobFlow makeQuizJobFlow;

    @BeforeEach
    void init() {
        makeQuizJobFlow = new MakeQuizJobFlow();
    }

    @Test
    public void JAVA_카테고리를_넣으면_JAVA에_해당되는_Job_이름을_세팅해준다() {
        String jobName = makeQuizJobFlow.getJobName(CategoryTitle.JAVA);

        assertThat(jobName).isEqualTo("makeJavaQuizJob");
    }
    @Test
    public void C_카테고리를_넣으면_C에_해당되는_Job_이름을_세팅해준다() {
        String jobName = makeQuizJobFlow.getJobName(CategoryTitle.C);

        assertThat(jobName).isEqualTo("makeCQuizJob");
    }
    @Test
    public void COMPUTER_SCIENCE_카테고리를_넣으면_COMPUTER_SCIENCE에_해당되는_Job_이름을_세팅해준다() {
        String jobName = makeQuizJobFlow.getJobName(CategoryTitle.COMPUTER_SCIENCE);

        assertThat(jobName).isEqualTo("makeComputerScienceQuizJob");
    }
    @Test
    public void DATABASE_카테고리를_넣으면_DATABASE에_해당되는_Job_이름을_세팅해준다() {
        String jobName = makeQuizJobFlow.getJobName(CategoryTitle.DATABASE);

        assertThat(jobName).isEqualTo("makeDatabaseQuizJob");
    }
    @Test
    public void DJANGO_카테고리를_넣으면_DJANGO에_해당되는_Job_이름을_세팅해준다() {
        String jobName = makeQuizJobFlow.getJobName(CategoryTitle.DJANGO);

        assertThat(jobName).isEqualTo("makeDjangoQuizJob");
    }
    @Test
    public void LINUX_카테고리를_넣으면_LINUX에_해당되는_Job_이름을_세팅해준다() {
        String jobName = makeQuizJobFlow.getJobName(CategoryTitle.LINUX);

        assertThat(jobName).isEqualTo("makeLinuxQuizJob");
    }
    @Test
    public void PYTHON_카테고리를_넣으면_PYTHON에_해당되는_Job_이름을_세팅해준다() {
        String jobName = makeQuizJobFlow.getJobName(CategoryTitle.PYTHON);

        assertThat(jobName).isEqualTo("makePythonQuizJob");
    }
    @Test
    public void REACT_카테고리를_넣으면_REACT에_해당되는_Job_이름을_세팅해준다() {
        String jobName = makeQuizJobFlow.getJobName(CategoryTitle.REACT);

        assertThat(jobName).isEqualTo("makeReactQuizJob");
    }
    @Test
    public void JAVASCRIPT_카테고리를_넣으면_JAVASCRIPT에_해당되는_Job_이름을_세팅해준다() {
        String jobName = makeQuizJobFlow.getJobName(CategoryTitle.JAVASCRIPT);

        assertThat(jobName).isEqualTo("makeJavascriptQuizJob");
    }
    @Test
    public void JPA_카테고리를_넣으면_JPA에_해당되는_Job_이름을_세팅해준다() {
        String jobName = makeQuizJobFlow.getJobName(CategoryTitle.JPA);

        assertThat(jobName).isEqualTo("makeJpaQuizJob");
    }
    @Test
    public void SPRING_카테고리를_넣으면_SPRING에_해당되는_Job_이름을_세팅해준다() {
        String jobName = makeQuizJobFlow.getJobName(CategoryTitle.SPRING);

        assertThat(jobName).isEqualTo("makeSpringQuizJob");
    }
    @Test
    public void NETWORK_카테고리를_넣으면_NETWORK에_해당되는_Job_이름을_세팅해준다() {
        String jobName = makeQuizJobFlow.getJobName(CategoryTitle.NETWORK);

        assertThat(jobName).isEqualTo("makeNetworkQuizJob");
    }
}
