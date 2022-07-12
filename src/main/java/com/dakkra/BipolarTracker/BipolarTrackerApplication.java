package com.dakkra.BipolarTracker;

import com.dakkra.BipolarTracker.MoodEntry.MoodEntry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class BipolarTrackerApplication {

	public static void main( String[] args ) {
		SpringApplication.run( BipolarTrackerApplication.class, args );
	}
}
