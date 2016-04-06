package org.cavebeetle.maven2.data;

import com.google.common.base.Preconditions;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Interner;
import com.google.common.collect.Interners;

public final class UpstreamProject
        implements
            Comparable<UpstreamProject>
{
    private static final Interner<UpstreamProject> INTERNER = Interners.newWeakInterner();

    public static final UpstreamProject make(final Project project, final Reason reason)
    {
        return INTERNER.intern(new UpstreamProject(project, reason));
    }

    private final Project value;
    private final Reason reason;

    public UpstreamProject(final Project value, final Reason reason)
    {
        Preconditions.checkArgument(value != null, "Missing 'value'.");
        Preconditions.checkArgument(reason != null, "Missing 'reason'.");
        this.value = value;
        this.reason = reason;
    }

    public Project value()
    {
        return value;
    }

    public Reason reason()
    {
        return reason;
    }

    @Override
    public String toString()
    {
        return String.format("[UpstreamProject value='%s' reason=%s]", value, reason);
    }

    @Override
    public int compareTo(final UpstreamProject other)
    {
        return ComparisonChain
                .start()
                .compare(value, other.value())
                .compare(reason, other.reason())
                .result();
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + value.hashCode();
        result = prime * result + reason.hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object object)
    {
        if (this == object)
        {
            return true;
        }
        if (object == null || getClass() != object.getClass())
        {
            return false;
        }
        final UpstreamProject other = (UpstreamProject) object;
        return compareTo(other) == 0;
    }
}
