# DDD練習
ディレクトリ構造とVOは踏襲して練習してみる。

## 要求仕様
### Input
- 出発地（東京固定）
- 目的地
- 出発日
- 人数
    - 大人
    - 子供
- 指定席 or 自由席
- 列車区分
- 片道往復

### Output
- 料金

# ドメインモデル
## Value Object -> domain/model/specification
- 大人人数
- 子供人数
- 出発日
- 場所 目的地
- 目的地
- 座席区分
- 列車種類
- 片道/往復

## Domain Model -> domain/model
- 料金ルール (Fare System)