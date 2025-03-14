package com.wipro.kafka.service;

import com.wipro.kafka.model.Enrollment;
import com.wipro.kafka.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;



@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    @Transactional
    public Enrollment enrollUser(Long userId, Long courseId) {
        Enrollment enrollment = new Enrollment(null, userId, courseId);
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getEnrollmentsByUser(Long userId) {
        return enrollmentRepository.findByUserId(userId);
    }

    public List<Enrollment> getEnrollmentsByCourse(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    @Transactional
    public void unenrollUser(Long userId, Long courseId) {
        enrollmentRepository.deleteAll(enrollmentRepository.findByUserId(userId));
    }
}
