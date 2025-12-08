INSERT INTO board (name, description, user_active, admin_active)
VALUES
    ('Notice', '공지사항 및 중요 안내를 위한 게시판입니다.', TRUE, TRUE),
    ('AboutMe', '개인 소개 및 자유로운 이야기를 나누는 게시판입니다.', TRUE, TRUE),
    ('Q&A', '질문과 답변을 위한 게시판입니다. 궁금한 점을 올려주세요.', TRUE, TRUE),
    ('CLang', 'C/C++ 프로그래밍 언어 관련 게시판입니다.', TRUE, TRUE),
    ('Java', 'Java 프로그래밍 언어 관련 게시판입니다.', TRUE, TRUE),
    ('JavaScript', 'JavaScript 및 프론트엔드 기술 관련 게시판입니다.', TRUE, TRUE),
    ('SQL', 'MySQL, MariaDB 등 데이터베이스 및 SQL 관련 게시판입니다.', TRUE, TRUE),
    ('TEST', '시스템 테스트 및 개발자용 임시 게시판입니다.', FALSE, TRUE),
    ('Private', '관리자 전용 비공개 게시판입니다. 일반 사용자는 접근할 수 없습니다.', FALSE, TRUE),
    ('Trash', '삭제된 게시글을 임시 보관하는 휴지통 공간입니다.', FALSE, FALSE);
INSERT INTO post (
    board_id,
    author_id,
    password,
    title,
    content,
    view_count,
    ip_hash,
    created_at,
    updated_at,
    attachment_url,
    thumbnail_url,
    access_level,
    status,
    is_notice,
    is_secret
) VALUES (
             1,                                -- board_id (공지사항 게시판)
             'admin',                          -- author_id
             'admin123',                       -- password
             '사이트 오픈 안내',                 -- title
             '저희 홈페이지가 정식으로 오픈했습니다. 많은 관심 부탁드립니다.', -- content
             10,                               -- view_count
             'abc123hash',                     -- ip_hash
             NOW(),                            -- created_at
             NOW(),                            -- updated_at
             'http://example.com/file.pdf',    -- attachment_url
             'http://example.com/thumb.jpg',   -- thumbnail_url
             0,                                -- access_level
             'active',                         -- status
             TRUE,                             -- is_notice
             FALSE                             -- is_secret
         );
-- 게시글 ID 1번에 대한 댓글들
INSERT INTO comment (post_id, author_id, password, content, ip_hash)
VALUES
    (1, 'userA', 'pass123', '첫 번째 댓글입니다.', '192.168.0.1'),
    (1, 'userB', 'pass456', '두 번째 댓글, 테스트용입니다.', '192.168.0.2'),
    (1, 'userC', NULL, '비밀번호 없이 작성한 댓글입니다.', '192.168.0.3');

-- 게시글 ID 2번에 대한 댓글들
INSERT INTO comment (post_id, author_id, password, content, ip_hash)
VALUES
    (2, 'userD', 'secret789', '게시글 2에 대한 첫 댓글!', '192.168.0.4'),
    (2, 'userE', 'pw000', '두 번째 댓글, 내용 확인용.', '192.168.0.5');
