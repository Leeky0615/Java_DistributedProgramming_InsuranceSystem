package constants;

import common.enummapper.EnumMapperType;

public enum GenderType implements EnumMapperType {
    MALE("남성"),
    FEMALE("여성");

    private final String value;

    GenderType(String value) {
        this.value = value;
    }

    @Override
    public String getCode() {
        return name();
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
