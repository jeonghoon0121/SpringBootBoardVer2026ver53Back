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

