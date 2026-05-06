# TestHub
テストケース管理・テスト実行・リリース単位の進捗可視化を行うWebアプリケーションです。
テストプロセスを「データとして管理」し、実行状況を定量的に把握することを目的としています。

## 背景

ゲーム開発やQA業務では、テストケースや実行状況が
複数のツールやスプレッドシートに分散し、管理が煩雑になることが多い。

その結果

- テスト進捗の把握が難しい
- 「どこまで終わっているのか」が定量的に見えない
- テスト実行結果とリリースの関係が曖昧になりやすい
- Excelやスプレッドシートでの管理では、更新・共有・整合性維持に限界がある

という課題がある。


課題に対するアプローチ
これらの問題を解決するために、以下のような方針でアプリケーションを設計しました。
- テストケース・テスト実行・リリースを明確に分離したドメイン設計
- リリース単位で進捗を集計し、可視化する仕組みの構築
- テスト実行をデータとして蓄積し、状態管理を可能にする構造
- 将来的な拡張（Bug管理やCI連携）を前提とした責務分離

設計上の意図
単なるCRUDアプリケーションではなく、
- 「テストを管理する」のではなく「テストプロセスを構造化する」
- 状態や進捗を「計算可能なデータ」として扱うことを目的としています。

そのため、ドメイン・アプリケーションサービス・インフラを分離し、
拡張性と保守性を意識した設計を採用しました。

## 機能
1. テストケース管理
- テストケースの作成・一覧表示
- テスト内容の管理（タイトル / 詳細）
- バージョン管理（TestCaseVersion）

2. テスト実行
- テスト実行の記録（TestRun）
- 実行結果の管理

3. リリース管理
- リリース単位でのテストケース紐付け
- リリースごとのテスト進捗管理

4. ダッシュボード
- リリースごとの進捗状況を可視化
- 完了率の集計表示

## 使用技術
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- Thymeleaf
- Maven
- MySQL

## アーキテクチャ
本アプリケーションは、レイヤードアーキテクチャ + DDDの考え方をベースに設計しています。

Controller
  ↓
Application Service
  ↓
Domain
  ↓
Repository (Interface)
  ↓
Infrastructure (JPA)

## ディレクトリ構成
com.example.testhub
├── controller                # Web層（画面・API）
├── application
│   ├── service              # アプリケーションサービス
│   └── dto                  # 画面・API用データ
├── domain                   # ドメインモデル
│   ├── testcase
│   ├── release
│   └── testrun
├── infrastructure
│   ├── jpa
│   │   ├── entity           # DBエンティティ
│   │   ├── repository       # JPA実装
│   │   └── mapper           # Entity⇔Domain変換
│   └── config
└── config                   # セキュリティ等

## 設計のポイント
1. ドメインとDBの分離
- DomainモデルとJPA Entityを分離
- Mapperを介して変換
　→永続化技術に依存しない設計

2. Application Serviceの導入
- ビジネスロジックはService層に集約
- Controllerは処理を持たない
例：
・TestCaseManagementService
・ReleaseProgressService
・TestExecutionApplicationService

3. DTOによる責務分離
- 画面/API用のデータ構造としてDTOを使用
- Domainを直接外部に公開しない

4. リリース単位の集約
- Releaseを軸にテストケースを管理
- 進捗はRelease単位で算出


## セットアップ
1. リポジトリをclone
git clone https://github.com/nulfu/TestHub.git

cd TestHub

2. 起動
./mvnw spring-boot:run

## 画面一覧
- /dashboard : ダッシュボード
- /testcases : テストケース一覧
- /releases : リリース管理
- /execution : テスト実行

## 今後の課題
機能改善
- テストケース検索機能
- UI/UX改善
- APIのREST化
- 認証・認可の強化

## Bug管理機能（追加予定）
現在の設計を拡張し、Bug管理機能の追加を予定しています。

想定機能
- バグの登録 / 更新 / 削除
- バグステータス管理（未対応 / 対応中 / 完了）
- テストケースとの紐付け
- リリース単位でのバグ管理

設計方針
- TestCaseとは別ドメインとして定義
- Releaseと関連付けることで進捗に統合
- 将来的に品質指標として活用

## 今後の拡張
- テスト実行履歴の蓄積
- CI/CDとの連携
- 自動テスト結果の取り込み
- メトリクス可視化（品質・進捗）