package eu.telecomnancy.profrdv.server.model.attribute;
//https://coderedirect.com/questions/606524/persist-java-8-localtime-in-jpa
//http://www.mastertheboss.com/hibernate-jpa/quickstart-tutorials-hibernate-jpa/using-localdate-and-localdatetime-with-jpa/
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
    public class LocalDateTimeAttributeConverter implements AttributeConverter<java.time.LocalDateTime, java.sql.Timestamp> {

        @Override
        public java.sql.Timestamp convertToDatabaseColumn(java.time.LocalDateTime attribute) {

            return attribute == null ? null : java.sql.Timestamp.valueOf(attribute);
        }
        @Override
        public java.time.LocalDateTime convertToEntityAttribute(java.sql.Timestamp dbData) {

            return dbData == null ? null : dbData.toLocalDateTime();
        }
    }