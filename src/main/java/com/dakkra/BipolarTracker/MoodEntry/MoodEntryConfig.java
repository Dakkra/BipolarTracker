package com.dakkra.BipolarTracker.MoodEntry;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class MoodEntryConfig {

	@Bean
	CommandLineRunner commandLineRunner(MoodEntryRepository repository) {
		return args -> {
			MoodEntry entry = new MoodEntry(10, 10, 10, LocalDate.now() );
			MoodEntry entry2 = new MoodEntry(1, 2, 3, LocalDate.of( 1994, 10, 29 ) );

			repository.saveAll(List.of(entry, entry2));
		};
	}
}
