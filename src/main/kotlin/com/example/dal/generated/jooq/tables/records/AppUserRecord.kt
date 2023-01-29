/*
 * This file is generated by jOOQ.
 */
package com.example.dal.generated.jooq.tables.records


import com.example.dal.generated.jooq.tables.AppUser

import org.jooq.Field
import org.jooq.Record1
import org.jooq.Record2
import org.jooq.Row2
import org.jooq.impl.UpdatableRecordImpl


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class AppUserRecord() : UpdatableRecordImpl<AppUserRecord>(AppUser.APP_USER), Record2<Int?, String?> {

    open var id: Int?
        set(value): Unit = set(0, value)
        get(): Int? = get(0) as Int?

    open var name: String?
        set(value): Unit = set(1, value)
        get(): String? = get(1) as String?

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    override fun key(): Record1<Int?> = super.key() as Record1<Int?>

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    override fun fieldsRow(): Row2<Int?, String?> = super.fieldsRow() as Row2<Int?, String?>
    override fun valuesRow(): Row2<Int?, String?> = super.valuesRow() as Row2<Int?, String?>
    override fun field1(): Field<Int?> = AppUser.APP_USER.ID
    override fun field2(): Field<String?> = AppUser.APP_USER.NAME
    override fun component1(): Int? = id
    override fun component2(): String? = name
    override fun value1(): Int? = id
    override fun value2(): String? = name

    override fun value1(value: Int?): AppUserRecord {
        this.id = value
        return this
    }

    override fun value2(value: String?): AppUserRecord {
        this.name = value
        return this
    }

    override fun values(value1: Int?, value2: String?): AppUserRecord {
        this.value1(value1)
        this.value2(value2)
        return this
    }

    /**
     * Create a detached, initialised AppUserRecord
     */
    constructor(id: Int? = null, name: String? = null): this() {
        this.id = id
        this.name = name
    }

    /**
     * Create a detached, initialised AppUserRecord
     */
    constructor(value: com.example.dal.generated.jooq.tables.pojos.AppUser?): this() {
        if (value != null) {
            this.id = value.id
            this.name = value.name
        }
    }
}
