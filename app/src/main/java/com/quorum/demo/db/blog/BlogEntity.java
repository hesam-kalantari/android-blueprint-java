package com.quorum.demo.db.blog;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.quorum.demo.db.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Getter
@Setter
@Entity(tableName = "TLB_BLOG")
@NoArgsConstructor
@AllArgsConstructor
public class BlogEntity extends BaseEntity
{

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "ID")
    private Integer id;

    @ColumnInfo(name = "TITLE")
    private String title;

    @ColumnInfo(name = "BODY")
    private String body;

    @ColumnInfo(name = "IMAGE")
    private String image;

    @ColumnInfo(name = "CATEGORY")
    private String category;

    @Override
    public int hashCode()
    {
        return new HashCodeBuilder(17, 37)
                .append(this.id)
                .toHashCode();

    }

    @Override
    public boolean equals(@Nullable final Object o)
    {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        final BlogEntity that = (BlogEntity) o;

        return new EqualsBuilder()
                .append(this.id, that.id)
                .isEquals();
    }
}
