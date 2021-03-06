package de.spaceboys.medicaltaskforce.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.of;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

import de.spaceboys.medicaltaskforce.entities.Volunteer;
import de.spaceboys.medicaltaskforce.mapper.VolunteerMapper;
import de.spaceboys.medicaltaskforce.repositories.VolunteerRepository;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/volunteers")
@RequiredArgsConstructor
public class VolunteerApi {

  private final VolunteerRepository volunteerRepository;
  private final VolunteerMapper volunteerMapper;

  @GetMapping
  public ResponseEntity<List<Volunteer>> getAllVolunteers() {
    return ok(volunteerRepository.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Volunteer> getVolunteerById(@PathVariable Long id) {
    return of(volunteerRepository.findById(id));
  }

  @PostMapping
  public ResponseEntity<Volunteer> createNewVolunteer(@Valid @RequestBody VolunteerDto volunteerDto) {
    return status(CREATED).body(volunteerRepository.save(volunteerMapper.volunteerDtoToVolunteer(volunteerDto)));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Volunteer> updateVolunteer(@PathVariable Long id,
      @Valid @RequestBody VolunteerDto volunteerDto) {
    Optional<Volunteer> volunteerOptional = volunteerRepository.findById(id);
    if (volunteerOptional.isPresent()) {
      return ok(volunteerRepository.save(volunteerMapper.volunteerDtoToVolunteer(volunteerDto)));
    } else {
      return notFound().build();
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Volunteer> deleteVolunteer(@PathVariable Long id) {
    volunteerRepository.deleteById(id);
    return noContent().build();
  }

}
