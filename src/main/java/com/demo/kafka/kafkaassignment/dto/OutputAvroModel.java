/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.demo.kafka.kafkaassignment.dto;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class OutputAvroModel extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -4031227732503989947L;


  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"OutputAvroModel\",\"namespace\":\"com.demo.kafka.kafkaassignment.dto\",\"fields\":[{\"name\":\"subscriber\",\"type\":{\"type\":\"record\",\"name\":\"Subscriber\",\"fields\":[{\"name\":\"case_NUMBER\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mem_ID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mem_FIRST_NAME\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mem_MIDDLE_NAME\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mem_LAST_NAME\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mem_ADD_1\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mem_ADD_2\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mem_CITY\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mem_PIN\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mysource\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}},{\"name\":\"mycase\",\"type\":{\"type\":\"record\",\"name\":\"Mycase\",\"fields\":[{\"name\":\"case_NUMBER\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"case_TYPE\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"case_CODE\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"case_START_DATE\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"case_END_DATE\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"case_AUTH_TYPE\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"case_STATUS\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mysource\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}},{\"name\":\"patient\",\"type\":{\"type\":\"record\",\"name\":\"Patient\",\"fields\":[{\"name\":\"case_NUMBER\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pat_ID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pat_FIRST_NAME\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pat_MIDDLE_NAME\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pat_LAST_NAME\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pat_SEX\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pat_DOB\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pat_PLANE_TYPE\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"pat_PLAN_NAME\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mysource\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}},{\"name\":\"service\",\"type\":{\"type\":\"record\",\"name\":\"Service\",\"fields\":[{\"name\":\"case_NUMBER\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"svc_ID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"svc_TYPE\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"svc_CODE\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"svc_FAC_ID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"svc_FAC_NAME\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"svc_PHY_ID\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"svc_PHY_NAME\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"mysource\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static final SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<OutputAvroModel> ENCODER =
      new BinaryMessageEncoder<OutputAvroModel>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<OutputAvroModel> DECODER =
      new BinaryMessageDecoder<OutputAvroModel>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<OutputAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<OutputAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<OutputAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<OutputAvroModel>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this OutputAvroModel to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a OutputAvroModel from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a OutputAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static OutputAvroModel fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  private Subscriber subscriber;
  private Mycase mycase;
  private Patient patient;
  private Service service;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public OutputAvroModel() {}

  /**
   * All-args constructor.
   * @param subscriber The new value for subscriber
   * @param mycase The new value for mycase
   * @param patient The new value for patient
   * @param service The new value for service
   */
  public OutputAvroModel(Subscriber subscriber, Mycase mycase, Patient patient, Service service) {
    this.subscriber = subscriber;
    this.mycase = mycase;
    this.patient = patient;
    this.service = service;
  }

  public SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public Object get(int field$) {
    switch (field$) {
    case 0: return subscriber;
    case 1: return mycase;
    case 2: return patient;
    case 3: return service;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, Object value$) {
    switch (field$) {
    case 0: subscriber = (Subscriber)value$; break;
    case 1: mycase = (Mycase)value$; break;
    case 2: patient = (Patient)value$; break;
    case 3: service = (Service)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'subscriber' field.
   * @return The value of the 'subscriber' field.
   */
  public Subscriber getSubscriber() {
    return subscriber;
  }


  /**
   * Sets the value of the 'subscriber' field.
   * @param value the value to set.
   */
  public void setSubscriber(Subscriber value) {
    this.subscriber = value;
  }

  /**
   * Gets the value of the 'mycase' field.
   * @return The value of the 'mycase' field.
   */
  public Mycase getMycase() {
    return mycase;
  }


  /**
   * Sets the value of the 'mycase' field.
   * @param value the value to set.
   */
  public void setMycase(Mycase value) {
    this.mycase = value;
  }

  /**
   * Gets the value of the 'patient' field.
   * @return The value of the 'patient' field.
   */
  public Patient getPatient() {
    return patient;
  }


  /**
   * Sets the value of the 'patient' field.
   * @param value the value to set.
   */
  public void setPatient(Patient value) {
    this.patient = value;
  }

  /**
   * Gets the value of the 'service' field.
   * @return The value of the 'service' field.
   */
  public Service getService() {
    return service;
  }


  /**
   * Sets the value of the 'service' field.
   * @param value the value to set.
   */
  public void setService(Service value) {
    this.service = value;
  }

  /**
   * Creates a new OutputAvroModel RecordBuilder.
   * @return A new OutputAvroModel RecordBuilder
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Creates a new OutputAvroModel RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new OutputAvroModel RecordBuilder
   */
  public static Builder newBuilder(Builder other) {
    if (other == null) {
      return new Builder();
    } else {
      return new Builder(other);
    }
  }

  /**
   * Creates a new OutputAvroModel RecordBuilder by copying an existing OutputAvroModel instance.
   * @param other The existing instance to copy.
   * @return A new OutputAvroModel RecordBuilder
   */
  public static Builder newBuilder(OutputAvroModel other) {
    if (other == null) {
      return new Builder();
    } else {
      return new Builder(other);
    }
  }

  /**
   * RecordBuilder for OutputAvroModel instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<OutputAvroModel>
    implements org.apache.avro.data.RecordBuilder<OutputAvroModel> {

    private Subscriber subscriber;
    private Subscriber.Builder subscriberBuilder;
    private Mycase mycase;
    private Mycase.Builder mycaseBuilder;
    private Patient patient;
    private Patient.Builder patientBuilder;
    private Service service;
    private Service.Builder serviceBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.subscriber)) {
        this.subscriber = data().deepCopy(fields()[0].schema(), other.subscriber);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (other.hasSubscriberBuilder()) {
        this.subscriberBuilder = Subscriber.newBuilder(other.getSubscriberBuilder());
      }
      if (isValidValue(fields()[1], other.mycase)) {
        this.mycase = data().deepCopy(fields()[1].schema(), other.mycase);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (other.hasMycaseBuilder()) {
        this.mycaseBuilder = Mycase.newBuilder(other.getMycaseBuilder());
      }
      if (isValidValue(fields()[2], other.patient)) {
        this.patient = data().deepCopy(fields()[2].schema(), other.patient);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (other.hasPatientBuilder()) {
        this.patientBuilder = Patient.newBuilder(other.getPatientBuilder());
      }
      if (isValidValue(fields()[3], other.service)) {
        this.service = data().deepCopy(fields()[3].schema(), other.service);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (other.hasServiceBuilder()) {
        this.serviceBuilder = Service.newBuilder(other.getServiceBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing OutputAvroModel instance
     * @param other The existing instance to copy.
     */
    private Builder(OutputAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.subscriber)) {
        this.subscriber = data().deepCopy(fields()[0].schema(), other.subscriber);
        fieldSetFlags()[0] = true;
      }
      this.subscriberBuilder = null;
      if (isValidValue(fields()[1], other.mycase)) {
        this.mycase = data().deepCopy(fields()[1].schema(), other.mycase);
        fieldSetFlags()[1] = true;
      }
      this.mycaseBuilder = null;
      if (isValidValue(fields()[2], other.patient)) {
        this.patient = data().deepCopy(fields()[2].schema(), other.patient);
        fieldSetFlags()[2] = true;
      }
      this.patientBuilder = null;
      if (isValidValue(fields()[3], other.service)) {
        this.service = data().deepCopy(fields()[3].schema(), other.service);
        fieldSetFlags()[3] = true;
      }
      this.serviceBuilder = null;
    }

    /**
      * Gets the value of the 'subscriber' field.
      * @return The value.
      */
    public Subscriber getSubscriber() {
      return subscriber;
    }


    /**
      * Sets the value of the 'subscriber' field.
      * @param value The value of 'subscriber'.
      * @return This builder.
      */
    public Builder setSubscriber(Subscriber value) {
      validate(fields()[0], value);
      this.subscriberBuilder = null;
      this.subscriber = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'subscriber' field has been set.
      * @return True if the 'subscriber' field has been set, false otherwise.
      */
    public boolean hasSubscriber() {
      return fieldSetFlags()[0];
    }

    /**
     * Gets the Builder instance for the 'subscriber' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public Subscriber.Builder getSubscriberBuilder() {
      if (subscriberBuilder == null) {
        if (hasSubscriber()) {
          setSubscriberBuilder(Subscriber.newBuilder(subscriber));
        } else {
          setSubscriberBuilder(Subscriber.newBuilder());
        }
      }
      return subscriberBuilder;
    }

    /**
     * Sets the Builder instance for the 'subscriber' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public Builder setSubscriberBuilder(Subscriber.Builder value) {
      clearSubscriber();
      subscriberBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'subscriber' field has an active Builder instance
     * @return True if the 'subscriber' field has an active Builder instance
     */
    public boolean hasSubscriberBuilder() {
      return subscriberBuilder != null;
    }

    /**
      * Clears the value of the 'subscriber' field.
      * @return This builder.
      */
    public Builder clearSubscriber() {
      subscriber = null;
      subscriberBuilder = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'mycase' field.
      * @return The value.
      */
    public Mycase getMycase() {
      return mycase;
    }


    /**
      * Sets the value of the 'mycase' field.
      * @param value The value of 'mycase'.
      * @return This builder.
      */
    public Builder setMycase(Mycase value) {
      validate(fields()[1], value);
      this.mycaseBuilder = null;
      this.mycase = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'mycase' field has been set.
      * @return True if the 'mycase' field has been set, false otherwise.
      */
    public boolean hasMycase() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'mycase' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public Mycase.Builder getMycaseBuilder() {
      if (mycaseBuilder == null) {
        if (hasMycase()) {
          setMycaseBuilder(Mycase.newBuilder(mycase));
        } else {
          setMycaseBuilder(Mycase.newBuilder());
        }
      }
      return mycaseBuilder;
    }

    /**
     * Sets the Builder instance for the 'mycase' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public Builder setMycaseBuilder(Mycase.Builder value) {
      clearMycase();
      mycaseBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'mycase' field has an active Builder instance
     * @return True if the 'mycase' field has an active Builder instance
     */
    public boolean hasMycaseBuilder() {
      return mycaseBuilder != null;
    }

    /**
      * Clears the value of the 'mycase' field.
      * @return This builder.
      */
    public Builder clearMycase() {
      mycase = null;
      mycaseBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'patient' field.
      * @return The value.
      */
    public Patient getPatient() {
      return patient;
    }


    /**
      * Sets the value of the 'patient' field.
      * @param value The value of 'patient'.
      * @return This builder.
      */
    public Builder setPatient(Patient value) {
      validate(fields()[2], value);
      this.patientBuilder = null;
      this.patient = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'patient' field has been set.
      * @return True if the 'patient' field has been set, false otherwise.
      */
    public boolean hasPatient() {
      return fieldSetFlags()[2];
    }

    /**
     * Gets the Builder instance for the 'patient' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public Patient.Builder getPatientBuilder() {
      if (patientBuilder == null) {
        if (hasPatient()) {
          setPatientBuilder(Patient.newBuilder(patient));
        } else {
          setPatientBuilder(Patient.newBuilder());
        }
      }
      return patientBuilder;
    }

    /**
     * Sets the Builder instance for the 'patient' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public Builder setPatientBuilder(Patient.Builder value) {
      clearPatient();
      patientBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'patient' field has an active Builder instance
     * @return True if the 'patient' field has an active Builder instance
     */
    public boolean hasPatientBuilder() {
      return patientBuilder != null;
    }

    /**
      * Clears the value of the 'patient' field.
      * @return This builder.
      */
    public Builder clearPatient() {
      patient = null;
      patientBuilder = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'service' field.
      * @return The value.
      */
    public Service getService() {
      return service;
    }


    /**
      * Sets the value of the 'service' field.
      * @param value The value of 'service'.
      * @return This builder.
      */
    public Builder setService(Service value) {
      validate(fields()[3], value);
      this.serviceBuilder = null;
      this.service = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'service' field has been set.
      * @return True if the 'service' field has been set, false otherwise.
      */
    public boolean hasService() {
      return fieldSetFlags()[3];
    }

    /**
     * Gets the Builder instance for the 'service' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public Service.Builder getServiceBuilder() {
      if (serviceBuilder == null) {
        if (hasService()) {
          setServiceBuilder(Service.newBuilder(service));
        } else {
          setServiceBuilder(Service.newBuilder());
        }
      }
      return serviceBuilder;
    }

    /**
     * Sets the Builder instance for the 'service' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public Builder setServiceBuilder(Service.Builder value) {
      clearService();
      serviceBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'service' field has an active Builder instance
     * @return True if the 'service' field has an active Builder instance
     */
    public boolean hasServiceBuilder() {
      return serviceBuilder != null;
    }

    /**
      * Clears the value of the 'service' field.
      * @return This builder.
      */
    public Builder clearService() {
      service = null;
      serviceBuilder = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public OutputAvroModel build() {
      try {
        OutputAvroModel record = new OutputAvroModel();
        if (subscriberBuilder != null) {
          try {
            record.subscriber = this.subscriberBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("subscriber"));
            throw e;
          }
        } else {
          record.subscriber = fieldSetFlags()[0] ? this.subscriber : (Subscriber) defaultValue(fields()[0]);
        }
        if (mycaseBuilder != null) {
          try {
            record.mycase = this.mycaseBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("mycase"));
            throw e;
          }
        } else {
          record.mycase = fieldSetFlags()[1] ? this.mycase : (Mycase) defaultValue(fields()[1]);
        }
        if (patientBuilder != null) {
          try {
            record.patient = this.patientBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("patient"));
            throw e;
          }
        } else {
          record.patient = fieldSetFlags()[2] ? this.patient : (Patient) defaultValue(fields()[2]);
        }
        if (serviceBuilder != null) {
          try {
            record.service = this.serviceBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("service"));
            throw e;
          }
        } else {
          record.service = fieldSetFlags()[3] ? this.service : (Service) defaultValue(fields()[3]);
        }
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<OutputAvroModel>
    WRITER$ = (org.apache.avro.io.DatumWriter<OutputAvroModel>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<OutputAvroModel>
    READER$ = (org.apache.avro.io.DatumReader<OutputAvroModel>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    this.subscriber.customEncode(out);

    this.mycase.customEncode(out);

    this.patient.customEncode(out);

    this.service.customEncode(out);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      if (this.subscriber == null) {
        this.subscriber = new Subscriber();
      }
      this.subscriber.customDecode(in);

      if (this.mycase == null) {
        this.mycase = new Mycase();
      }
      this.mycase.customDecode(in);

      if (this.patient == null) {
        this.patient = new Patient();
      }
      this.patient.customDecode(in);

      if (this.service == null) {
        this.service = new Service();
      }
      this.service.customDecode(in);

    } else {
      for (int i = 0; i < 4; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          if (this.subscriber == null) {
            this.subscriber = new Subscriber();
          }
          this.subscriber.customDecode(in);
          break;

        case 1:
          if (this.mycase == null) {
            this.mycase = new Mycase();
          }
          this.mycase.customDecode(in);
          break;

        case 2:
          if (this.patient == null) {
            this.patient = new Patient();
          }
          this.patient.customDecode(in);
          break;

        case 3:
          if (this.service == null) {
            this.service = new Service();
          }
          this.service.customDecode(in);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










