package com.udemy.spring_batch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration 
public class BatchConfig {
	
	//tasklet = usado para tarefas simples.
	// chunk = para tarefaz mais complexas ()
	
	
	
	
	
//	@Bean
  public Job imprimeOlaJob(JobRepository jobRepository, Step imprimeOlaStep) { 
      return new JobBuilder("imprimeOlaJob_2", jobRepository)
              .start(imprimeOlaStep)
              .incrementer(new RunIdIncrementer()) // para executar o job mais de uma vez e salvar os metadados no banco. Só usar quando o job nao for reinicializado
              .build();
  }
  
  
  
  

	
	

	
	//CHUNK 
	
//	@Bean
//	Job imprimirParImparJob(JobRepository jobRepository, Step imprimirParImparStep) {
//		return new JobBuilder("imprimirParImparJob",jobRepository)
//				.start(imprimirParImparStep)
//				.incrementer(new RunIdIncrementer())
//				.build();
//	}
//	
//	
//	@Bean
//	Step imprimirParImparStep(JobRepository jobRepositry, PlatformTransactionManager platformTransactionManager) {
//		
//		return new StepBuilder("imprimirParImparStep",jobRepositry)
//				.<Integer, String>chunk(10, platformTransactionManager) // Integer = tipo do item lido, String = tipo do item processado/escrito. O 1 é o tamanho do chunk.				
//				.reader(contarAteDezReader())
//				.processor(parOuImparProcessor())
//				.writer(imprimeWriter())
//				.build();
//				
//	}
//	
//	@Bean
//	ItemReader<Integer> contarAteDezReader() {
//	    List<Integer> numeroDeUmAteDez = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//	    return new ListItemReader<>(numeroDeUmAteDez); 
//	}
//	
//	@Bean
//	FunctionItemProcessor<Integer, String> parOuImparProcessor(){
//		
//		return new FunctionItemProcessor<Integer, String>
//		(item -> item % 2 == 0 ? String.format("Item %s é Par", item) : String.format("Item %s é Impar", item));
//		
//	}
//	
//	ItemWriter<String> imprimeWriter(){
//		
//		return itens -> itens.forEach(System.out::println);
//	}
	
	
//  TASKLET

	
//    @Bean
//    public Job imprimeOlaJob(JobRepository jobRepository, Step imprimeOlaStep) { 
//        return new JobBuilder("imprimeOlaJob_2", jobRepository)
//                .start(imprimeOlaStep)
//                .incrementer(new RunIdIncrementer()) // para executar o job mais de uma vez e salvar os metadados no banco. Só usar quando o job nao for reinicializado
//                .build();
//    }
//    
//    
    
    
//    @Bean
//    public Step imprimeOlaStep(JobRepository jobRepository, PlatformTransactionManager platformTransactionManager) { 
//        return new StepBuilder("imprimeOlaStep", jobRepository)
//                .tasklet((StepContribution stepContribution, ChunkContext chunkContext) -> {
//                    System.out.println("Olá batch!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//                    return RepeatStatus.FINISHED;
//                }, platformTransactionManager)
//                .build();
//    }
    
    
}