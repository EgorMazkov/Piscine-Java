INSERT INTO chat.user (id, login, password) VALUES (default, 'humbler', 'user');
INSERT INTO chat.user (id, login, password) VALUES (default, 'teardown', '123');
INSERT INTO chat.user (id, login, password) VALUES (default, 'biba', 'bob');
INSERT INTO chat.user (id, login, password) VALUES (default, 'bob', 'biba');
INSERT INTO chat.user (id, login, password) VALUES (default, 'lua', 'pupa');
INSERT INTO chat.user (id, login, password) VALUES (default, 'pupa', 'lua');
INSERT INTO chat.message (author_id, room_id, text, date_time) VALUES (1, 1, 'hello world', '2022-07-25 10:49:58.894317');
INSERT INTO chat.message (author_id, room_id, text, date_time) VALUES (1, 2, 'привет друзья', '2022-07-25 10:51:04.186772');
INSERT INTO chat.message (author_id, room_id, text, date_time) VALUES (2, 3, 'тут очень интересно', '2022-07-25 10:51:52.243987');
INSERT INTO chat.message (author_id, room_id, text, date_time) VALUES (4, 4, 'кукусики', '2022-07-25 10:51:52.243987');
INSERT INTO chat.message (author_id, room_id, text, date_time) VALUES (3, 5, 'купите пульт', '2022-07-25 10:51:52.243987');
INSERT INTO chat.chatroom (id, name, owner) VALUES (1, 'cs-go', 1);
INSERT INTO chat.chatroom (id, name, owner) VALUES (2, 'dota', 2);
INSERT INTO chat.chatroom (id, name, owner) VALUES (3, 'chat', 3);
INSERT INTO chat.chatroom (id, name, owner) VALUES (4, 'bulbul', 4);
INSERT INTO chat.chatroom (id, name, owner) VALUES (5, 'pult', 5);