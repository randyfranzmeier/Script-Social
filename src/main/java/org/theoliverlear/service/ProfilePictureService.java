package org.theoliverlear.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.theoliverlear.entity.user.ProfilePicture;
import org.theoliverlear.repository.ProfilePictureRepository;

@Service
public class ProfilePictureService {
    ProfilePictureRepository profilePictureRepository;
    @Autowired
    public ProfilePictureService(ProfilePictureRepository profilePictureRepository) {
        this.profilePictureRepository = profilePictureRepository;
    }
    public void saveProfilePicture(ProfilePicture profilePicture) {
        this.profilePictureRepository.save(profilePicture);
    }
    @Transactional
    public ProfilePicture findByUserId(Long userId) {
        return this.profilePictureRepository.findByUserId(userId);
    }
    public boolean existsByUserId(Long userId) {
        return this.profilePictureRepository.existsByUserId(userId);
    }
}
