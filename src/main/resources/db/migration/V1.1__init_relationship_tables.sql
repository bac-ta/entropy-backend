-- CREATE TABLE

CREATE TABLE ofCategory
(
    id        integer not null,
    name      varchar(255),
    status    tinyint,
    created   datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    createdBy varchar(255),
    updated   datetime,
    updatedBy varchar(255),
    primary key (id)
) engine=InnoDB;
CREATE TABLE ofCategoryTag
(
    categoryId integer not null,
    tagId      integer not null,
    primary key (categoryId, tagId)
) engine=InnoDB;
CREATE TABLE ofComment
(
    id        integer not null,
    content   TEXT,
    fileUrl   varchar(255),
    postId    integer,
    status    tinyint,
    username  varchar(255),
    created   datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    createdBy varchar(255),
    updated   datetime,
    updatedBy varchar(255),
    primary key (id)
) engine=InnoDB;
CREATE TABLE ofOAuth2User
(
    id        integer not null,
    email     varchar(255),
    name      varchar(255),
    type      tinyint,
    created   datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    createdBy varchar(255),
    updated   datetime,
    updatedBy varchar(255),
    primary key (id)
) engine=InnoDB;
CREATE TABLE ofPermission
(
    id        tinyint not null,
    name      varchar(255),
    created   datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    createdBy varchar(255),
    updated   datetime,
    updatedBy varchar(255),
    primary key (id)
) engine=InnoDB;
CREATE TABLE ofPost
(
    id            integer not null,
    author        varchar(255),
    content       LONGTEXT,
    imageTitleUrl varchar(255),
    publication   tinyint,
    status        tinyint,
    title         varchar(255),
    created       datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    createdBy     varchar(255),
    updated       datetime,
    updatedBy     varchar(255),
    primary key (id)
) engine=InnoDB;
CREATE TABLE ofPostCategory
(
    postId     integer not null,
    categoryId integer not null,
    primary key (postId, categoryId)
) engine=InnoDB;
CREATE TABLE ofPostTag
(
    id        integer not null,
    postId    integer,
    tagId     integer,
    created   datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    createdBy varchar(255),
    updated   datetime,
    updatedBy varchar(255),
    primary key (id)
) engine=InnoDB;
CREATE TABLE ofProfile
(
    id           integer not null,
    avatar       varchar(255),
    description  varchar(255),
    oauth2Avatar varchar(255),
    oauth2UserId integer,
    username     varchar(255),
    created      datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    createdBy    varchar(255),
    updated      datetime,
    updatedBy    varchar(255),
    primary key (id)
) engine=InnoDB;
CREATE TABLE ofRefreshToken
(
    id         integer not null,
    token      varchar(255),
    expiryDate bigint,
    username   varchar(255),
    created    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    createdBy  varchar(255),
    updated    datetime,
    updatedBy  varchar(255),
    primary key (id)
) engine=InnoDB;
CREATE TABLE ofReply
(
    id        integer not null,
    content   varchar(255),
    fileUrl   varchar(255),
    username  varchar(255),
    commentId integer,
    created   datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    createdBy varchar(255),
    updated   datetime,
    updatedBy varchar(255),
    primary key (id)
) engine=InnoDB;
CREATE TABLE ofRole
(
    id        tinyint not null auto_increment,
    name      varchar(255),
    created   datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    createdBy varchar(255),
    updated   datetime,
    updatedBy varchar(255),
    primary key (id)
) engine=InnoDB;
CREATE TABLE ofRolePermission
(
    roleId       tinyint not null,
    permissionId tinyint not null,
    primary key (roleId, permissionId)
) engine=InnoDB;
CREATE TABLE ofTag
(
    id         integer not null,
    name       varchar(255),
    categoryId integer,
    created    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    createdBy  varchar(255),
    updated    datetime,
    updatedBy  varchar(255),
    primary key (id)
) engine=InnoDB;

-- ALTER TABLE
ALTER TABLE ofUser
    add column created datetime NOT NULL DEFAULT CURRENT_TIMESTAMP;
ALTER TABLE ofUser
    add column createdBy varchar(255);
ALTER TABLE ofUser
    add column updated datetime;
ALTER TABLE ofUser
    add column updatedBy varchar(255);
ALTER TABLE ofUser
    add column bcryptedPassword varchar(255);
ALTER TABLE ofUser
    add column dateOfBirth date;
ALTER TABLE ofUser
    add column gender tinyint;
ALTER TABLE ofUser
    add column phone varchar(255);
ALTER TABLE ofUser
    add column status tinyint;
ALTER TABLE ofUser
    add column role tinyint;
ALTER TABLE ofCategoryTag
    add constraint FKsmvpli3djtuvhrw904b0hrdo0 foreign key (tagId) references ofTag (id);
ALTER TABLE ofCategoryTag
    add constraint FK9xeg8fxyl5k7rgg25785oni30 foreign key (categoryId) references ofCategory (id);
ALTER TABLE ofPostCategory
    add constraint FKn8jgmelc3r0fies121r74eigx foreign key (categoryId) references ofCategory (id);
ALTER TABLE ofPostCategory
    add constraint FKhdmc5elprml1qbiqgg25hi3cb foreign key (postId) references ofPost (id);
ALTER TABLE ofReply
    add constraint FKo4a1q6k3emy0a2c4ai4lj0i8j foreign key (commentId) references ofComment (id);
ALTER TABLE ofRolePermission
    add constraint FKmv1hdn7347m7omjw3q0naxg01 foreign key (permissionId) references ofPermission (id);
ALTER TABLE ofRolePermission
    add constraint FK67mblibght68b2j87q87ibo5d foreign key (roleId) references ofRole (id);
ALTER TABLE ofUser
    add constraint FKo4fx6enafgyaemy9gvqvsvamc foreign key (role) references ofRole (id);
