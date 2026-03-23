# TestHub
ゲームテストやQAの業務効率を改善することを目的とした、
テストケース管理Webアプリ

## 背景

ゲーム開発やQA業務では、テストケース・テスト結果・バグ情報が
複数のツールやスプレッドシートに分散し、管理が煩雑になることが多い。

その結果

- テスト進捗の把握が難しい
- バグの再現条件が追跡しにくい
- テストケースの再利用ができない

という課題がある。

TestHub はこれらを **一元管理することで QA 業務の効率化を目的としたアプリ**。

## 機能

### 認証
- Spring Security を使用したログイン認証
- セッション管理

### テストケース管理
- テストケースの作成
- 編集 / 削除
- 一覧表示

### テスト実行管理
- テスト実行結果の記録
- 成功 / 失敗管理

### バグ管理
- バグ登録
- ステータス管理
- バグ一覧表示

## 使用技術
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Thymeleaf
- MySQL

## アーキテクチャ
- MVCアーキテクチャ
- Controller / Service / Repository の3層構造

## セットアップ
1. リポジトリをclone
git clone https://github.com/xxxx/TestHub.git

2. MySQLを起動

3. application.propertiesを設定
spring.datasource.url=jdbc:mysql://localhost:3306/testhub

4. 起動
./mvnw spring-boot:run

## 今後の改善
- テストケース検索機能
- バグの優先度管理
- API化（REST API）
- Docker対応