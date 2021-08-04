create table ofCategory
(
    id        integer not null,
    created   datetime,
    createdBy varchar(255),
    updated   datetime,
    updatedBy varchar(255),
    name      varchar(255),
    status    tinyint,
    primary key (id)
) engine=InnoDB;
create table ofCategoryTag
(
    categoryId integer not null,
    tagId      integer not null,
    primary key (categoryId, tagId)
) engine=InnoDB;
create table ofComment
(
    id        integer not null,
    created   datetime,
    createdBy varchar(255),
    updated   datetime,
    updatedBy varchar(255),
    content   TEXT,
    fileUrl   varchar(255),
    postId    integer,
    status    tinyint,
    username  varchar(255),
    primary key (id)
) engine=InnoDB;
create table ofOAuth2User
(
    id        integer not null,
    created   datetime,
    createdBy varchar(255),
    updated   datetime,
    updatedBy varchar(255),
    email     varchar(255),
    name      varchar(255),
    type      tinyint,
    primary key (id)
) engine=InnoDB;
create table ofPermission
(
    id        tinyint not null,
    created   datetime,
    createdBy varchar(255),
    updated   datetime,
    updatedBy varchar(255),
    name      varchar(255),
    primary key (id)
) engine=InnoDB;
create table ofPost
(
    id            integer not null,
    created       datetime,
    createdBy     varchar(255),
    updated       datetime,
    updatedBy     varchar(255),
    author        varchar(255),
    content       LONGTEXT,
    imageTitleUrl varchar(255),
    publication   tinyint,
    status        tinyint,
    title         varchar(255),
    primary key (id)
) engine=InnoDB;
create table ofPostCategory
(
    postId     integer not null,
    categoryId integer not null,
    primary key (postId, categoryId)
) engine=InnoDB;
create table ofPostTag
(
    id        integer not null,
    created   datetime,
    createdBy varchar(255),
    updated   datetime,
    updatedBy varchar(255),
    postId    integer,
    tagId     integer,
    primary key (id)
) engine=InnoDB;
create table ofProfile
(
    id           integer not null,
    created      datetime,
    createdBy    varchar(255),
    updated      datetime,
    updatedBy    varchar(255),
    avatar       varchar(255),
    description  varchar(255),
    oauth2Avatar varchar(255),
    oauth2UserId integer,
    username     varchar(255),
    primary key (id)
) engine=InnoDB;
create table ofRefreshToken
(
    id         integer not null,
    created    datetime,
    createdBy  varchar(255),
    updated    datetime,
    updatedBy  varchar(255),
    expiryDate bigint,
    token      varchar(255),
    username   varchar(255),
    primary key (id)
) engine=InnoDB;
create table ofReply
(
    id        integer not null,
    created   datetime,
    createdBy varchar(255),
    updated   datetime,
    updatedBy varchar(255),
    content   varchar(255),
    fileUrl   varchar(255),
    username  varchar(255),
    commentId integer,
    primary key (id)
) engine=InnoDB;
create table ofRole
(
    id        tinyint not null auto_increment,
    created   datetime,
    createdBy varchar(255),
    updated   datetime,
    updatedBy varchar(255),
    name      varchar(255),
    primary key (id)
) engine=InnoDB;
create table ofRolePermission
(
    roleId       tinyint not null,
    permissionId tinyint not null,
    primary key (roleId, permissionId)
) engine=InnoDB;
create table ofTag
(
    id         integer not null,
    created    datetime,
    createdBy  varchar(255),
    updated    datetime,
    updatedBy  varchar(255),
    categoryId integer,
    name       varchar(255),
    primary key (id)
) engine=InnoDB;
create table ofUser
(
    username          varchar(255) not null,
    created           datetime,
    createdBy         varchar(255),
    updated           datetime,
    updatedBy         varchar(255),
    bcryptedPassword  varchar(255),
    dateOfBirth       date,
    email             varchar(255),
    encryptedPassword varchar(255),
    gender            tinyint,
    iterations        integer,
    name              varchar(255),
    phone             varchar(255),
    plainPassword     varchar(255),
    salt              varchar(255),
    serverKey         varchar(255),
    status            tinyint      not null default 1,
    storedKey         varchar(255),
    primary key (username)
) engine=InnoDB;
create table ofUserRole
(
    userId varchar(255) not null,
    roleId tinyint      not null,
    primary key (userId, roleId)
) engine=InnoDB;
alter table ofCategoryTag
    add constraint FKsmvpli3djtuvhrw904b0hrdo0 foreign key (tagId) references ofTag (id);
alter table ofCategoryTag
    add constraint FK9xeg8fxyl5k7rgg25785oni30 foreign key (categoryId) references ofCategory (id);
alter table ofPostCategory
    add constraint FKn8jgmelc3r0fies121r74eigx foreign key (categoryId) references ofCategory (id);
alter table ofPostCategory
    add constraint FKhdmc5elprml1qbiqgg25hi3cb foreign key (postId) references ofPost (id);
alter table ofReply
    add constraint FKo4a1q6k3emy0a2c4ai4lj0i8j foreign key (commentId) references ofComment (id);
alter table ofRolePermission
    add constraint FKmv1hdn7347m7omjw3q0naxg01 foreign key (permissionId) references ofPermission (id);
alter table ofRolePermission
    add constraint FK67mblibght68b2j87q87ibo5d foreign key (roleId) references ofRole (id);
alter table ofUserRole
    add constraint FKri8559d8huxsdo7ig8chjvmqq foreign key (roleId) references ofRole (id);
alter table ofUserRole
    add constraint FKapaq6kx9tldhx1o2rk3w03phw foreign key (userId) references ofUser (username);