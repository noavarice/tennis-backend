package com.github.sportstats.rest.validation.group.sequence;

import com.github.sportstats.rest.validation.group.BuiltIn;
import com.github.sportstats.rest.validation.group.Custom;
import com.github.sportstats.rest.validation.group.Required;
import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * Mandates order of validation for constraints with both specified and unspecified groups.
 *
 * @author noavarice
 * @since 0.0.1
 */
@GroupSequence({
    Required.class,
    BuiltIn.class,
    Custom.class,
    Default.class,
})
public interface DefaultOrder {}
