package com.wipro.kafka.event;

public class EnrollmentEvent {

    private Long userId;
    private Long courseId;
    private String status; // e.g., "ENROLLED" or "UNENROLLED"

    // Default constructor (Required for Kafka serialization)
    public EnrollmentEvent() {
    }

    public EnrollmentEvent(Long userId, Long courseId, String status) {
        this.userId = userId;
        this.courseId = courseId;
        this.status = status;
    }

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "EnrollmentEvent{" +
                "userId=" + userId +
                ", courseId=" + courseId +
                ", status='" + status + '\'' +
                '}';
    }
}
