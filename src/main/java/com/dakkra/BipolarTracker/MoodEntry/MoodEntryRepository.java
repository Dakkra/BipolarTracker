package com.dakkra.BipolarTracker.MoodEntry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface MoodEntryRepository extends JpaRepository<MoodEntry, Long>
{

	@Query("SELECT s FROM MoodEntry s WHERE s.date = ?1")
	Optional<MoodEntry> findMoodEntriesByDate( LocalDate date );

}
