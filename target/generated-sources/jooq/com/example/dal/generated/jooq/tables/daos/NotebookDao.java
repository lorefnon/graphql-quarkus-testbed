/*
 * This file is generated by jOOQ.
 */
package com.example.dal.generated.jooq.tables.daos;


import com.example.dal.generated.jooq.tables.Notebook;
import com.example.dal.generated.jooq.tables.records.NotebookRecord;

import java.util.List;
import java.util.Optional;

import org.jooq.Configuration;
import org.jooq.impl.DAOImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class NotebookDao extends DAOImpl<NotebookRecord, com.example.dal.generated.jooq.tables.pojos.Notebook, Integer> {

    /**
     * Create a new NotebookDao without any configuration
     */
    public NotebookDao() {
        super(Notebook.NOTEBOOK, com.example.dal.generated.jooq.tables.pojos.Notebook.class);
    }

    /**
     * Create a new NotebookDao with an attached configuration
     */
    public NotebookDao(Configuration configuration) {
        super(Notebook.NOTEBOOK, com.example.dal.generated.jooq.tables.pojos.Notebook.class, configuration);
    }

    @Override
    public Integer getId(com.example.dal.generated.jooq.tables.pojos.Notebook object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.example.dal.generated.jooq.tables.pojos.Notebook> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Notebook.NOTEBOOK.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.example.dal.generated.jooq.tables.pojos.Notebook> fetchById(Integer... values) {
        return fetch(Notebook.NOTEBOOK.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.example.dal.generated.jooq.tables.pojos.Notebook fetchOneById(Integer value) {
        return fetchOne(Notebook.NOTEBOOK.ID, value);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public Optional<com.example.dal.generated.jooq.tables.pojos.Notebook> fetchOptionalById(Integer value) {
        return fetchOptional(Notebook.NOTEBOOK.ID, value);
    }

    /**
     * Fetch records that have <code>title BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.example.dal.generated.jooq.tables.pojos.Notebook> fetchRangeOfTitle(String lowerInclusive, String upperInclusive) {
        return fetchRange(Notebook.NOTEBOOK.TITLE, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>title IN (values)</code>
     */
    public List<com.example.dal.generated.jooq.tables.pojos.Notebook> fetchByTitle(String... values) {
        return fetch(Notebook.NOTEBOOK.TITLE, values);
    }

    /**
     * Fetch records that have <code>description BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.example.dal.generated.jooq.tables.pojos.Notebook> fetchRangeOfDescription(String lowerInclusive, String upperInclusive) {
        return fetchRange(Notebook.NOTEBOOK.DESCRIPTION, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>description IN (values)</code>
     */
    public List<com.example.dal.generated.jooq.tables.pojos.Notebook> fetchByDescription(String... values) {
        return fetch(Notebook.NOTEBOOK.DESCRIPTION, values);
    }

    /**
     * Fetch records that have <code>creator_id BETWEEN lowerInclusive AND
     * upperInclusive</code>
     */
    public List<com.example.dal.generated.jooq.tables.pojos.Notebook> fetchRangeOfCreatorId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Notebook.NOTEBOOK.CREATOR_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>creator_id IN (values)</code>
     */
    public List<com.example.dal.generated.jooq.tables.pojos.Notebook> fetchByCreatorId(Integer... values) {
        return fetch(Notebook.NOTEBOOK.CREATOR_ID, values);
    }
}
