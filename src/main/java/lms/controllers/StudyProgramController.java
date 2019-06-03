package lms.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lms.domain.StudyProgram;
import lms.repository.StudyProgramRepository;
import lms.service.StudyProgramService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/studyprogram")
public class StudyProgramController {

	@Autowired
	StudyProgramService studyProgramService;
	
	@Autowired
	StudyProgramRepository studyProgramRepository;
	
	@RequestMapping()
	public ResponseEntity<Iterable<StudyProgram>> getAllStudyProgram() {
		return new ResponseEntity<Iterable<StudyProgram>>(studyProgramService.getAllStidyProgram(), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<StudyProgram> getStudyProgramById(@PathVariable Long id) {
		Optional<StudyProgram> studyProgram = studyProgramService.getStudyProgramId(id);
		if (studyProgram.isPresent()) {
			return new ResponseEntity<StudyProgram>(studyProgram.get(), HttpStatus.OK);
		}
		return new ResponseEntity<StudyProgram>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<StudyProgram> addStudyProgram(@RequestBody StudyProgram studyProgram) {

		studyProgramService.addStudyProgram(studyProgram);
		return new ResponseEntity<StudyProgram>(studyProgram, HttpStatus.CREATED);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<StudyProgram> updateStudyProgram(@PathVariable Long id, @RequestBody StudyProgram studyProgram) {
		studyProgramService.updateStudyProgram(id, studyProgram);
		return new ResponseEntity<StudyProgram>(studyProgram, HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<StudyProgram> removeStudyProgram(@PathVariable Long id) {
		try {
			studyProgramService.removeStudyProgram(id);
		} catch (Exception e) {
			return new ResponseEntity<StudyProgram>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<StudyProgram>(HttpStatus.NO_CONTENT);
	}
	
	
	@GetMapping(value = "/name/{name}")
	public ResponseEntity<Iterable<StudyProgram>> getStudyProgramByTitle(@PathVariable String name) {
		return new ResponseEntity<Iterable<StudyProgram>>(studyProgramService.getStudyProgramByName(name), HttpStatus.OK);
	}
	
	@PostMapping("/file/upload")
	public String uploadMultipartFile(@RequestParam("file") MultipartFile file, @RequestParam("name") String name, @RequestParam("center") String center) {
		try {
			// save file to PostgreSQL
			StudyProgram filemode = new StudyProgram(file, name, center);
			studyProgramRepository.save(filemode);
			return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
		} catch (Exception e) {
			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
		}
	}
}
