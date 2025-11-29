package org.example.cheeseservice.repository;

import org.example.cheeseservice.entity.Texture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextureRepository extends JpaRepository<Texture,Long> {
}
