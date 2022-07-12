package com.dakkra.BipolarTracker.MoodEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MoodEntryService {

	private final MoodEntryRepository moodEntryRepository;

	@Autowired
	public MoodEntryService( MoodEntryRepository moodEntryRepository ) {
		this.moodEntryRepository = moodEntryRepository;
	}

	public List<MoodEntry> getEntries() {
		return moodEntryRepository.findAll();
	}

	@Transactional
	public void addNewEntry( MoodEntry entry ) {
		Optional<MoodEntry> existingOptional = moodEntryRepository.findMoodEntriesByDate( entry.getDate() );
		if( existingOptional.isPresent() ) {
			//update entry
			Optional<MoodEntry> existingIdOption = moodEntryRepository.findById( existingOptional.get().getId() );
			MoodEntry existing = existingIdOption.get();
			existing.setDepression( entry.getDepression() ).setMania( entry.getMania() ).setOverall( entry.getOverall() );
		} else {
			moodEntryRepository.save( entry );
		}
	}

	public void deleteEntry( Long id ) {
		Optional<MoodEntry> entryOptional = moodEntryRepository.findById( id );
		if (entryOptional.isPresent()) {
			moodEntryRepository.delete( entryOptional.get() );
		}else {
			throw new IllegalArgumentException("Id is not valid");
		}
	}
}
