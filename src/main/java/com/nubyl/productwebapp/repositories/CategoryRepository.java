/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nubyl.productwebapp.repositories;

import com.nubyl.productwebapp.entities.CategoryEntity;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author buynl
 */
@Repository
public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer>{
    
}
