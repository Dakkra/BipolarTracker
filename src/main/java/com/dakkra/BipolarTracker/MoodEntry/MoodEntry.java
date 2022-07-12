package com.dakkra.BipolarTracker.MoodEntry;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@ToString
@Entity
@Table
public class MoodEntry {

	@Id
	@Getter
	@Setter
	@Accessors(chain = true)
	@SequenceGenerator(
		name = "moodentry_sequence",
		sequenceName = "moodentry_sequence",
		allocationSize = 1
	)
	@GeneratedValue(
		strategy = GenerationType.SEQUENCE,
		generator = "moodentry_sequence"
	)
	private Long id;

	@Getter
	@Setter
	@Accessors(chain = true)
	private Integer mania;

	@Getter
	@Setter
	@Accessors(chain = true)
	private Integer depression;

	@Getter
	@Setter
	@Accessors(chain = true)
	private Integer overall;

	@Getter
	@Setter
	@Accessors(chain = true)
	private LocalDate date;

	public MoodEntry( long id, int mania, int depression, int overall, LocalDate date ) {
		this.id = id;
		this.mania = mania;
		this.depression = depression;
		this.overall = overall;
		this.date = date;
	}

	public MoodEntry(int mania, int depression, int overall, LocalDate date ) {
		this.mania = mania;
		this.depression = depression;
		this.overall = overall;
		this.date = date;
	}
}
