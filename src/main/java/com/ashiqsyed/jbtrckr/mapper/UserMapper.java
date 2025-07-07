package com.ashiqsyed.jbtrckr.mapper;

import com.ashiqsyed.jbtrckr.dto.JobApplicationDTO;
import com.ashiqsyed.jbtrckr.dto.UserDTO;
import com.ashiqsyed.jbtrckr.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {




    public static UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }

        List<JobApplicationDTO> jobApplicationDtos = user.getJobApplications()
                .stream().map(JobApplicationMapper::toDTO).toList();

        UserDTO userDto = new UserDTO(user.getEmail(), user.getUsername(), user.getId());
        userDto.setJobApplications(jobApplicationDtos);
        return userDto;
    }
}
