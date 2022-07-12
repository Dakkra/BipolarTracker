package com.dakkra.BipolarTracker.MoodEntry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping( path = "api/v1/moodentry" )
public class MoodEntryController {

	private final MoodEntryService entryService;

	@Autowired
	public MoodEntryController( MoodEntryService service ) {
		this.entryService = service;
	}

	@GetMapping
	public List<MoodEntry> getEntries() {
		return entryService.getEntries();
	}

	@PostMapping
	public void makeNewEntry( @RequestBody MoodEntry entry ) {
		entryService.addNewEntry( entry );
	}

	@DeleteMapping( path = "{id}" )
	public void deleteEntry( @PathVariable( "id" ) Long id ) {
		entryService.deleteEntry( id );
	}
}
