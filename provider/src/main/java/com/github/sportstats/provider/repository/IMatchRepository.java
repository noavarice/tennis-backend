package com.github.sportstats.provider.repository;

import com.github.sportstats.provider.model.MatchEntity;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * Repository to work with {@link MatchEntity matches}.
 *
 * @author noavarice
 * @since 0.0.1
 */
@RepositoryDefinition(domainClass = MatchEntity.class, idClass = Integer.class)
public interface IMatchRepository {

  MatchEntity save(final MatchEntity entity);
}
