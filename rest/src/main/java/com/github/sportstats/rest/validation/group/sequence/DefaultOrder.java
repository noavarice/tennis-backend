package com.github.sportstats.rest.validation.group.sequence;

import com.github.sportstats.rest.validation.group.BuiltIn;
import com.github.sportstats.rest.validation.group.Custom;
import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({
    BuiltIn.class,
    Custom.class,
    Default.class,
})
public interface DefaultOrder {}
