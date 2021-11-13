create table streams_log
(
    id                          int auto_increment,
    event_type                  varchar(100) not null,
    event_time                  timestamp    not null,
    transaction_time            timestamp    not null,
    symbol                      varchar(50)  not null,
    pair                        varchar(50)  not null,
    first_update_id             bigint       not null,
    final_update_id             bigint       not null,
    final_update_id_last_stream bigint       not null,
    constraint streams_log_id_uindex
        unique (id)
);

alter table streams_log
    add primary key (id);

create table stream_bids_asks
(
    id        int auto_increment,
    stream_id int  not null,
    bids      text not null,
    asks      text not null,
    constraint stream_bids_asks_id_uindex
        unique (id),
    constraint stream_bids_asks_streams_log_id_fk
        foreign key (stream_id) references streams_log (id)
);

alter table stream_bids_asks
    add primary key (id);

