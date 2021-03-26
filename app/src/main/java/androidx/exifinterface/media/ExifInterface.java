package androidx.exifinterface.media;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.util.Log;
import android.util.Pair;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExifInterface {
    public static final short ALTITUDE_ABOVE_SEA_LEVEL = 0;
    public static final short ALTITUDE_BELOW_SEA_LEVEL = 1;
    static final Charset ASCII;
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_1 = {4};
    public static final int[] BITS_PER_SAMPLE_GREYSCALE_2 = {8};
    public static final int[] BITS_PER_SAMPLE_RGB = {8, 8, 8};
    static final short BYTE_ALIGN_II = 18761;
    static final short BYTE_ALIGN_MM = 19789;
    public static final int COLOR_SPACE_S_RGB = 1;
    public static final int COLOR_SPACE_UNCALIBRATED = 65535;
    public static final short CONTRAST_HARD = 2;
    public static final short CONTRAST_NORMAL = 0;
    public static final short CONTRAST_SOFT = 1;
    public static final int DATA_DEFLATE_ZIP = 8;
    public static final int DATA_HUFFMAN_COMPRESSED = 2;
    public static final int DATA_JPEG = 6;
    public static final int DATA_JPEG_COMPRESSED = 7;
    public static final int DATA_LOSSY_JPEG = 34892;
    public static final int DATA_PACK_BITS_COMPRESSED = 32773;
    public static final int DATA_UNCOMPRESSED = 1;
    private static final boolean DEBUG = false;
    static final byte[] EXIF_ASCII_PREFIX = {65, 83, 67, 73, 73, 0, 0, 0};
    private static final ExifTag[] EXIF_POINTER_TAGS = {new ExifTag("SubIFDPointer", 330, 4), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("CameraSettingsIFDPointer", 8224, 1), new ExifTag("ImageProcessingIFDPointer", 8256, 1)};
    static final ExifTag[][] EXIF_TAGS;
    public static final short EXPOSURE_MODE_AUTO = 0;
    public static final short EXPOSURE_MODE_AUTO_BRACKET = 2;
    public static final short EXPOSURE_MODE_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_ACTION = 6;
    public static final short EXPOSURE_PROGRAM_APERTURE_PRIORITY = 3;
    public static final short EXPOSURE_PROGRAM_CREATIVE = 5;
    public static final short EXPOSURE_PROGRAM_LANDSCAPE_MODE = 8;
    public static final short EXPOSURE_PROGRAM_MANUAL = 1;
    public static final short EXPOSURE_PROGRAM_NORMAL = 2;
    public static final short EXPOSURE_PROGRAM_NOT_DEFINED = 0;
    public static final short EXPOSURE_PROGRAM_PORTRAIT_MODE = 7;
    public static final short EXPOSURE_PROGRAM_SHUTTER_PRIORITY = 4;
    public static final short FILE_SOURCE_DSC = 3;
    public static final short FILE_SOURCE_OTHER = 0;
    public static final short FILE_SOURCE_REFLEX_SCANNER = 2;
    public static final short FILE_SOURCE_TRANSPARENT_SCANNER = 1;
    public static final short FLAG_FLASH_FIRED = 1;
    public static final short FLAG_FLASH_MODE_AUTO = 24;
    public static final short FLAG_FLASH_MODE_COMPULSORY_FIRING = 8;
    public static final short FLAG_FLASH_MODE_COMPULSORY_SUPPRESSION = 16;
    public static final short FLAG_FLASH_NO_FLASH_FUNCTION = 32;
    public static final short FLAG_FLASH_RED_EYE_SUPPORTED = 64;
    public static final short FLAG_FLASH_RETURN_LIGHT_DETECTED = 6;
    public static final short FLAG_FLASH_RETURN_LIGHT_NOT_DETECTED = 4;
    private static final List<Integer> FLIPPED_ROTATION_ORDER = Arrays.asList(2, 7, 4, 5);
    public static final short FORMAT_CHUNKY = 1;
    public static final short FORMAT_PLANAR = 2;
    public static final short GAIN_CONTROL_HIGH_GAIN_DOWN = 4;
    public static final short GAIN_CONTROL_HIGH_GAIN_UP = 2;
    public static final short GAIN_CONTROL_LOW_GAIN_DOWN = 3;
    public static final short GAIN_CONTROL_LOW_GAIN_UP = 1;
    public static final short GAIN_CONTROL_NONE = 0;
    public static final String GPS_DIRECTION_MAGNETIC = "M";
    public static final String GPS_DIRECTION_TRUE = "T";
    public static final String GPS_DISTANCE_KILOMETERS = "K";
    public static final String GPS_DISTANCE_MILES = "M";
    public static final String GPS_DISTANCE_NAUTICAL_MILES = "N";
    public static final String GPS_MEASUREMENT_2D = "2";
    public static final String GPS_MEASUREMENT_3D = "3";
    public static final short GPS_MEASUREMENT_DIFFERENTIAL_CORRECTED = 1;
    public static final String GPS_MEASUREMENT_INTERRUPTED = "V";
    public static final String GPS_MEASUREMENT_IN_PROGRESS = "A";
    public static final short GPS_MEASUREMENT_NO_DIFFERENTIAL = 0;
    public static final String GPS_SPEED_KILOMETERS_PER_HOUR = "K";
    public static final String GPS_SPEED_KNOTS = "N";
    public static final String GPS_SPEED_MILES_PER_HOUR = "M";
    static final byte[] IDENTIFIER_EXIF_APP1;
    private static final ExifTag[] IFD_EXIF_TAGS;
    private static final int IFD_FORMAT_BYTE = 1;
    static final int[] IFD_FORMAT_BYTES_PER_FORMAT = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    private static final int IFD_FORMAT_DOUBLE = 12;
    private static final int IFD_FORMAT_IFD = 13;
    static final String[] IFD_FORMAT_NAMES = {"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
    private static final int IFD_FORMAT_SBYTE = 6;
    private static final int IFD_FORMAT_SINGLE = 11;
    private static final int IFD_FORMAT_SLONG = 9;
    private static final int IFD_FORMAT_SRATIONAL = 10;
    private static final int IFD_FORMAT_SSHORT = 8;
    private static final int IFD_FORMAT_STRING = 2;
    private static final int IFD_FORMAT_ULONG = 4;
    private static final int IFD_FORMAT_UNDEFINED = 7;
    private static final int IFD_FORMAT_URATIONAL = 5;
    private static final int IFD_FORMAT_USHORT = 3;
    private static final ExifTag[] IFD_GPS_TAGS;
    private static final ExifTag[] IFD_INTEROPERABILITY_TAGS;
    private static final int IFD_OFFSET = 8;
    private static final ExifTag[] IFD_THUMBNAIL_TAGS;
    private static final ExifTag[] IFD_TIFF_TAGS;
    private static final int IFD_TYPE_EXIF = 1;
    private static final int IFD_TYPE_GPS = 2;
    private static final int IFD_TYPE_INTEROPERABILITY = 3;
    private static final int IFD_TYPE_ORF_CAMERA_SETTINGS = 7;
    private static final int IFD_TYPE_ORF_IMAGE_PROCESSING = 8;
    private static final int IFD_TYPE_ORF_MAKER_NOTE = 6;
    private static final int IFD_TYPE_PEF = 9;
    static final int IFD_TYPE_PREVIEW = 5;
    static final int IFD_TYPE_PRIMARY = 0;
    static final int IFD_TYPE_THUMBNAIL = 4;
    private static final int IMAGE_TYPE_ARW = 1;
    private static final int IMAGE_TYPE_CR2 = 2;
    private static final int IMAGE_TYPE_DNG = 3;
    private static final int IMAGE_TYPE_JPEG = 4;
    private static final int IMAGE_TYPE_NEF = 5;
    private static final int IMAGE_TYPE_NRW = 6;
    private static final int IMAGE_TYPE_ORF = 7;
    private static final int IMAGE_TYPE_PEF = 8;
    private static final int IMAGE_TYPE_RAF = 9;
    private static final int IMAGE_TYPE_RW2 = 10;
    private static final int IMAGE_TYPE_SRW = 11;
    private static final int IMAGE_TYPE_UNKNOWN = 0;
    private static final ExifTag JPEG_INTERCHANGE_FORMAT_LENGTH_TAG = new ExifTag("JPEGInterchangeFormatLength", 514, 4);
    private static final ExifTag JPEG_INTERCHANGE_FORMAT_TAG = new ExifTag("JPEGInterchangeFormat", 513, 4);
    static final byte[] JPEG_SIGNATURE = {-1, -40, -1};
    public static final String LATITUDE_NORTH = "N";
    public static final String LATITUDE_SOUTH = "S";
    public static final short LIGHT_SOURCE_CLOUDY_WEATHER = 10;
    public static final short LIGHT_SOURCE_COOL_WHITE_FLUORESCENT = 14;
    public static final short LIGHT_SOURCE_D50 = 23;
    public static final short LIGHT_SOURCE_D55 = 20;
    public static final short LIGHT_SOURCE_D65 = 21;
    public static final short LIGHT_SOURCE_D75 = 22;
    public static final short LIGHT_SOURCE_DAYLIGHT = 1;
    public static final short LIGHT_SOURCE_DAYLIGHT_FLUORESCENT = 12;
    public static final short LIGHT_SOURCE_DAY_WHITE_FLUORESCENT = 13;
    public static final short LIGHT_SOURCE_FINE_WEATHER = 9;
    public static final short LIGHT_SOURCE_FLASH = 4;
    public static final short LIGHT_SOURCE_FLUORESCENT = 2;
    public static final short LIGHT_SOURCE_ISO_STUDIO_TUNGSTEN = 24;
    public static final short LIGHT_SOURCE_OTHER = 255;
    public static final short LIGHT_SOURCE_SHADE = 11;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_A = 17;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_B = 18;
    public static final short LIGHT_SOURCE_STANDARD_LIGHT_C = 19;
    public static final short LIGHT_SOURCE_TUNGSTEN = 3;
    public static final short LIGHT_SOURCE_UNKNOWN = 0;
    public static final short LIGHT_SOURCE_WARM_WHITE_FLUORESCENT = 16;
    public static final short LIGHT_SOURCE_WHITE_FLUORESCENT = 15;
    public static final String LONGITUDE_EAST = "E";
    public static final String LONGITUDE_WEST = "W";
    static final byte MARKER = -1;
    static final byte MARKER_APP1 = -31;
    private static final byte MARKER_COM = -2;
    static final byte MARKER_EOI = -39;
    private static final byte MARKER_SOF0 = -64;
    private static final byte MARKER_SOF1 = -63;
    private static final byte MARKER_SOF10 = -54;
    private static final byte MARKER_SOF11 = -53;
    private static final byte MARKER_SOF13 = -51;
    private static final byte MARKER_SOF14 = -50;
    private static final byte MARKER_SOF15 = -49;
    private static final byte MARKER_SOF2 = -62;
    private static final byte MARKER_SOF3 = -61;
    private static final byte MARKER_SOF5 = -59;
    private static final byte MARKER_SOF6 = -58;
    private static final byte MARKER_SOF7 = -57;
    private static final byte MARKER_SOF9 = -55;
    private static final byte MARKER_SOI = -40;
    private static final byte MARKER_SOS = -38;
    private static final int MAX_THUMBNAIL_SIZE = 512;
    public static final short METERING_MODE_AVERAGE = 1;
    public static final short METERING_MODE_CENTER_WEIGHT_AVERAGE = 2;
    public static final short METERING_MODE_MULTI_SPOT = 4;
    public static final short METERING_MODE_OTHER = 255;
    public static final short METERING_MODE_PARTIAL = 6;
    public static final short METERING_MODE_PATTERN = 5;
    public static final short METERING_MODE_SPOT = 3;
    public static final short METERING_MODE_UNKNOWN = 0;
    private static final ExifTag[] ORF_CAMERA_SETTINGS_TAGS;
    private static final ExifTag[] ORF_IMAGE_PROCESSING_TAGS;
    private static final byte[] ORF_MAKER_NOTE_HEADER_1 = {79, 76, 89, 77, 80, 0};
    private static final int ORF_MAKER_NOTE_HEADER_1_SIZE = 8;
    private static final byte[] ORF_MAKER_NOTE_HEADER_2 = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final int ORF_MAKER_NOTE_HEADER_2_SIZE = 12;
    private static final ExifTag[] ORF_MAKER_NOTE_TAGS;
    private static final short ORF_SIGNATURE_1 = 20306;
    private static final short ORF_SIGNATURE_2 = 21330;
    public static final int ORIENTATION_FLIP_HORIZONTAL = 2;
    public static final int ORIENTATION_FLIP_VERTICAL = 4;
    public static final int ORIENTATION_NORMAL = 1;
    public static final int ORIENTATION_ROTATE_180 = 3;
    public static final int ORIENTATION_ROTATE_270 = 8;
    public static final int ORIENTATION_ROTATE_90 = 6;
    public static final int ORIENTATION_TRANSPOSE = 5;
    public static final int ORIENTATION_TRANSVERSE = 7;
    public static final int ORIENTATION_UNDEFINED = 0;
    public static final int ORIGINAL_RESOLUTION_IMAGE = 0;
    private static final int PEF_MAKER_NOTE_SKIP_SIZE = 6;
    private static final String PEF_SIGNATURE = "PENTAX";
    private static final ExifTag[] PEF_TAGS;
    public static final int PHOTOMETRIC_INTERPRETATION_BLACK_IS_ZERO = 1;
    public static final int PHOTOMETRIC_INTERPRETATION_RGB = 2;
    public static final int PHOTOMETRIC_INTERPRETATION_WHITE_IS_ZERO = 0;
    public static final int PHOTOMETRIC_INTERPRETATION_YCBCR = 6;
    private static final int RAF_INFO_SIZE = 160;
    private static final int RAF_JPEG_LENGTH_VALUE_SIZE = 4;
    private static final int RAF_OFFSET_TO_JPEG_IMAGE_OFFSET = 84;
    private static final String RAF_SIGNATURE = "FUJIFILMCCD-RAW";
    public static final int REDUCED_RESOLUTION_IMAGE = 1;
    public static final short RENDERED_PROCESS_CUSTOM = 1;
    public static final short RENDERED_PROCESS_NORMAL = 0;
    public static final short RESOLUTION_UNIT_CENTIMETERS = 3;
    public static final short RESOLUTION_UNIT_INCHES = 2;
    private static final List<Integer> ROTATION_ORDER = Arrays.asList(1, 6, 3, 8);
    private static final short RW2_SIGNATURE = 85;
    public static final short SATURATION_HIGH = 0;
    public static final short SATURATION_LOW = 0;
    public static final short SATURATION_NORMAL = 0;
    public static final short SCENE_CAPTURE_TYPE_LANDSCAPE = 1;
    public static final short SCENE_CAPTURE_TYPE_NIGHT = 3;
    public static final short SCENE_CAPTURE_TYPE_PORTRAIT = 2;
    public static final short SCENE_CAPTURE_TYPE_STANDARD = 0;
    public static final short SCENE_TYPE_DIRECTLY_PHOTOGRAPHED = 1;
    public static final short SENSITIVITY_TYPE_ISO_SPEED = 3;
    public static final short SENSITIVITY_TYPE_REI = 2;
    public static final short SENSITIVITY_TYPE_REI_AND_ISO = 6;
    public static final short SENSITIVITY_TYPE_SOS = 1;
    public static final short SENSITIVITY_TYPE_SOS_AND_ISO = 5;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI = 4;
    public static final short SENSITIVITY_TYPE_SOS_AND_REI_AND_ISO = 7;
    public static final short SENSITIVITY_TYPE_UNKNOWN = 0;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL = 5;
    public static final short SENSOR_TYPE_COLOR_SEQUENTIAL_LINEAR = 8;
    public static final short SENSOR_TYPE_NOT_DEFINED = 1;
    public static final short SENSOR_TYPE_ONE_CHIP = 2;
    public static final short SENSOR_TYPE_THREE_CHIP = 4;
    public static final short SENSOR_TYPE_TRILINEAR = 7;
    public static final short SENSOR_TYPE_TWO_CHIP = 3;
    public static final short SHARPNESS_HARD = 2;
    public static final short SHARPNESS_NORMAL = 0;
    public static final short SHARPNESS_SOFT = 1;
    private static final int SIGNATURE_CHECK_SIZE = 5000;
    static final byte START_CODE = 42;
    public static final short SUBJECT_DISTANCE_RANGE_CLOSE_VIEW = 2;
    public static final short SUBJECT_DISTANCE_RANGE_DISTANT_VIEW = 3;
    public static final short SUBJECT_DISTANCE_RANGE_MACRO = 1;
    public static final short SUBJECT_DISTANCE_RANGE_UNKNOWN = 0;
    private static final String TAG = "ExifInterface";
    public static final String TAG_APERTURE_VALUE = "ApertureValue";
    public static final String TAG_ARTIST = "Artist";
    public static final String TAG_BITS_PER_SAMPLE = "BitsPerSample";
    public static final String TAG_BODY_SERIAL_NUMBER = "BodySerialNumber";
    public static final String TAG_BRIGHTNESS_VALUE = "BrightnessValue";
    public static final String TAG_CAMARA_OWNER_NAME = "CameraOwnerName";
    public static final String TAG_CFA_PATTERN = "CFAPattern";
    public static final String TAG_COLOR_SPACE = "ColorSpace";
    public static final String TAG_COMPONENTS_CONFIGURATION = "ComponentsConfiguration";
    public static final String TAG_COMPRESSED_BITS_PER_PIXEL = "CompressedBitsPerPixel";
    public static final String TAG_COMPRESSION = "Compression";
    public static final String TAG_CONTRAST = "Contrast";
    public static final String TAG_COPYRIGHT = "Copyright";
    public static final String TAG_CUSTOM_RENDERED = "CustomRendered";
    public static final String TAG_DATETIME = "DateTime";
    public static final String TAG_DATETIME_DIGITIZED = "DateTimeDigitized";
    public static final String TAG_DATETIME_ORIGINAL = "DateTimeOriginal";
    public static final String TAG_DEFAULT_CROP_SIZE = "DefaultCropSize";
    public static final String TAG_DEVICE_SETTING_DESCRIPTION = "DeviceSettingDescription";
    public static final String TAG_DIGITAL_ZOOM_RATIO = "DigitalZoomRatio";
    public static final String TAG_DNG_VERSION = "DNGVersion";
    private static final String TAG_EXIF_IFD_POINTER = "ExifIFDPointer";
    public static final String TAG_EXIF_VERSION = "ExifVersion";
    public static final String TAG_EXPOSURE_BIAS_VALUE = "ExposureBiasValue";
    public static final String TAG_EXPOSURE_INDEX = "ExposureIndex";
    public static final String TAG_EXPOSURE_MODE = "ExposureMode";
    public static final String TAG_EXPOSURE_PROGRAM = "ExposureProgram";
    public static final String TAG_EXPOSURE_TIME = "ExposureTime";
    public static final String TAG_FILE_SOURCE = "FileSource";
    public static final String TAG_FLASH = "Flash";
    public static final String TAG_FLASHPIX_VERSION = "FlashpixVersion";
    public static final String TAG_FLASH_ENERGY = "FlashEnergy";
    public static final String TAG_FOCAL_LENGTH = "FocalLength";
    public static final String TAG_FOCAL_LENGTH_IN_35MM_FILM = "FocalLengthIn35mmFilm";
    public static final String TAG_FOCAL_PLANE_RESOLUTION_UNIT = "FocalPlaneResolutionUnit";
    public static final String TAG_FOCAL_PLANE_X_RESOLUTION = "FocalPlaneXResolution";
    public static final String TAG_FOCAL_PLANE_Y_RESOLUTION = "FocalPlaneYResolution";
    public static final String TAG_F_NUMBER = "FNumber";
    public static final String TAG_GAIN_CONTROL = "GainControl";
    public static final String TAG_GAMMA = "Gamma";
    public static final String TAG_GPS_ALTITUDE = "GPSAltitude";
    public static final String TAG_GPS_ALTITUDE_REF = "GPSAltitudeRef";
    public static final String TAG_GPS_AREA_INFORMATION = "GPSAreaInformation";
    public static final String TAG_GPS_DATESTAMP = "GPSDateStamp";
    public static final String TAG_GPS_DEST_BEARING = "GPSDestBearing";
    public static final String TAG_GPS_DEST_BEARING_REF = "GPSDestBearingRef";
    public static final String TAG_GPS_DEST_DISTANCE = "GPSDestDistance";
    public static final String TAG_GPS_DEST_DISTANCE_REF = "GPSDestDistanceRef";
    public static final String TAG_GPS_DEST_LATITUDE = "GPSDestLatitude";
    public static final String TAG_GPS_DEST_LATITUDE_REF = "GPSDestLatitudeRef";
    public static final String TAG_GPS_DEST_LONGITUDE = "GPSDestLongitude";
    public static final String TAG_GPS_DEST_LONGITUDE_REF = "GPSDestLongitudeRef";
    public static final String TAG_GPS_DIFFERENTIAL = "GPSDifferential";
    public static final String TAG_GPS_DOP = "GPSDOP";
    public static final String TAG_GPS_H_POSITIONING_ERROR = "GPSHPositioningError";
    public static final String TAG_GPS_IMG_DIRECTION = "GPSImgDirection";
    public static final String TAG_GPS_IMG_DIRECTION_REF = "GPSImgDirectionRef";
    private static final String TAG_GPS_INFO_IFD_POINTER = "GPSInfoIFDPointer";
    public static final String TAG_GPS_LATITUDE = "GPSLatitude";
    public static final String TAG_GPS_LATITUDE_REF = "GPSLatitudeRef";
    public static final String TAG_GPS_LONGITUDE = "GPSLongitude";
    public static final String TAG_GPS_LONGITUDE_REF = "GPSLongitudeRef";
    public static final String TAG_GPS_MAP_DATUM = "GPSMapDatum";
    public static final String TAG_GPS_MEASURE_MODE = "GPSMeasureMode";
    public static final String TAG_GPS_PROCESSING_METHOD = "GPSProcessingMethod";
    public static final String TAG_GPS_SATELLITES = "GPSSatellites";
    public static final String TAG_GPS_SPEED = "GPSSpeed";
    public static final String TAG_GPS_SPEED_REF = "GPSSpeedRef";
    public static final String TAG_GPS_STATUS = "GPSStatus";
    public static final String TAG_GPS_TIMESTAMP = "GPSTimeStamp";
    public static final String TAG_GPS_TRACK = "GPSTrack";
    public static final String TAG_GPS_TRACK_REF = "GPSTrackRef";
    public static final String TAG_GPS_VERSION_ID = "GPSVersionID";
    private static final String TAG_HAS_THUMBNAIL = "HasThumbnail";
    public static final String TAG_IMAGE_DESCRIPTION = "ImageDescription";
    public static final String TAG_IMAGE_LENGTH = "ImageLength";
    public static final String TAG_IMAGE_UNIQUE_ID = "ImageUniqueID";
    public static final String TAG_IMAGE_WIDTH = "ImageWidth";
    private static final String TAG_INTEROPERABILITY_IFD_POINTER = "InteroperabilityIFDPointer";
    public static final String TAG_INTEROPERABILITY_INDEX = "InteroperabilityIndex";
    public static final String TAG_ISO_SPEED = "ISOSpeed";
    public static final String TAG_ISO_SPEED_LATITUDE_YYY = "ISOSpeedLatitudeyyy";
    public static final String TAG_ISO_SPEED_LATITUDE_ZZZ = "ISOSpeedLatitudezzz";
    @Deprecated
    public static final String TAG_ISO_SPEED_RATINGS = "ISOSpeedRatings";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT = "JPEGInterchangeFormat";
    public static final String TAG_JPEG_INTERCHANGE_FORMAT_LENGTH = "JPEGInterchangeFormatLength";
    public static final String TAG_LENS_MAKE = "LensMake";
    public static final String TAG_LENS_MODEL = "LensModel";
    public static final String TAG_LENS_SERIAL_NUMBER = "LensSerialNumber";
    public static final String TAG_LENS_SPECIFICATION = "LensSpecification";
    public static final String TAG_LIGHT_SOURCE = "LightSource";
    public static final String TAG_MAKE = "Make";
    public static final String TAG_MAKER_NOTE = "MakerNote";
    public static final String TAG_MAX_APERTURE_VALUE = "MaxApertureValue";
    public static final String TAG_METERING_MODE = "MeteringMode";
    public static final String TAG_MODEL = "Model";
    public static final String TAG_NEW_SUBFILE_TYPE = "NewSubfileType";
    public static final String TAG_OECF = "OECF";
    public static final String TAG_ORF_ASPECT_FRAME = "AspectFrame";
    private static final String TAG_ORF_CAMERA_SETTINGS_IFD_POINTER = "CameraSettingsIFDPointer";
    private static final String TAG_ORF_IMAGE_PROCESSING_IFD_POINTER = "ImageProcessingIFDPointer";
    public static final String TAG_ORF_PREVIEW_IMAGE_LENGTH = "PreviewImageLength";
    public static final String TAG_ORF_PREVIEW_IMAGE_START = "PreviewImageStart";
    public static final String TAG_ORF_THUMBNAIL_IMAGE = "ThumbnailImage";
    public static final String TAG_ORIENTATION = "Orientation";
    public static final String TAG_PHOTOGRAPHIC_SENSITIVITY = "PhotographicSensitivity";
    public static final String TAG_PHOTOMETRIC_INTERPRETATION = "PhotometricInterpretation";
    public static final String TAG_PIXEL_X_DIMENSION = "PixelXDimension";
    public static final String TAG_PIXEL_Y_DIMENSION = "PixelYDimension";
    public static final String TAG_PLANAR_CONFIGURATION = "PlanarConfiguration";
    public static final String TAG_PRIMARY_CHROMATICITIES = "PrimaryChromaticities";
    private static final ExifTag TAG_RAF_IMAGE_SIZE = new ExifTag("StripOffsets", 273, 3);
    public static final String TAG_RECOMMENDED_EXPOSURE_INDEX = "RecommendedExposureIndex";
    public static final String TAG_REFERENCE_BLACK_WHITE = "ReferenceBlackWhite";
    public static final String TAG_RELATED_SOUND_FILE = "RelatedSoundFile";
    public static final String TAG_RESOLUTION_UNIT = "ResolutionUnit";
    public static final String TAG_ROWS_PER_STRIP = "RowsPerStrip";
    public static final String TAG_RW2_ISO = "ISO";
    public static final String TAG_RW2_JPG_FROM_RAW = "JpgFromRaw";
    public static final String TAG_RW2_SENSOR_BOTTOM_BORDER = "SensorBottomBorder";
    public static final String TAG_RW2_SENSOR_LEFT_BORDER = "SensorLeftBorder";
    public static final String TAG_RW2_SENSOR_RIGHT_BORDER = "SensorRightBorder";
    public static final String TAG_RW2_SENSOR_TOP_BORDER = "SensorTopBorder";
    public static final String TAG_SAMPLES_PER_PIXEL = "SamplesPerPixel";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_SCENE_CAPTURE_TYPE = "SceneCaptureType";
    public static final String TAG_SCENE_TYPE = "SceneType";
    public static final String TAG_SENSING_METHOD = "SensingMethod";
    public static final String TAG_SENSITIVITY_TYPE = "SensitivityType";
    public static final String TAG_SHARPNESS = "Sharpness";
    public static final String TAG_SHUTTER_SPEED_VALUE = "ShutterSpeedValue";
    public static final String TAG_SOFTWARE = "Software";
    public static final String TAG_SPATIAL_FREQUENCY_RESPONSE = "SpatialFrequencyResponse";
    public static final String TAG_SPECTRAL_SENSITIVITY = "SpectralSensitivity";
    public static final String TAG_STANDARD_OUTPUT_SENSITIVITY = "StandardOutputSensitivity";
    public static final String TAG_STRIP_BYTE_COUNTS = "StripByteCounts";
    public static final String TAG_STRIP_OFFSETS = "StripOffsets";
    public static final String TAG_SUBFILE_TYPE = "SubfileType";
    public static final String TAG_SUBJECT_AREA = "SubjectArea";
    public static final String TAG_SUBJECT_DISTANCE = "SubjectDistance";
    public static final String TAG_SUBJECT_DISTANCE_RANGE = "SubjectDistanceRange";
    public static final String TAG_SUBJECT_LOCATION = "SubjectLocation";
    public static final String TAG_SUBSEC_TIME = "SubSecTime";
    public static final String TAG_SUBSEC_TIME_DIGITIZED = "SubSecTimeDigitized";
    public static final String TAG_SUBSEC_TIME_ORIGINAL = "SubSecTimeOriginal";
    private static final String TAG_SUB_IFD_POINTER = "SubIFDPointer";
    private static final String TAG_THUMBNAIL_DATA = "ThumbnailData";
    public static final String TAG_THUMBNAIL_IMAGE_LENGTH = "ThumbnailImageLength";
    public static final String TAG_THUMBNAIL_IMAGE_WIDTH = "ThumbnailImageWidth";
    private static final String TAG_THUMBNAIL_LENGTH = "ThumbnailLength";
    private static final String TAG_THUMBNAIL_OFFSET = "ThumbnailOffset";
    public static final String TAG_TRANSFER_FUNCTION = "TransferFunction";
    public static final String TAG_USER_COMMENT = "UserComment";
    public static final String TAG_WHITE_BALANCE = "WhiteBalance";
    public static final String TAG_WHITE_POINT = "WhitePoint";
    public static final String TAG_X_RESOLUTION = "XResolution";
    public static final String TAG_Y_CB_CR_COEFFICIENTS = "YCbCrCoefficients";
    public static final String TAG_Y_CB_CR_POSITIONING = "YCbCrPositioning";
    public static final String TAG_Y_CB_CR_SUB_SAMPLING = "YCbCrSubSampling";
    public static final String TAG_Y_RESOLUTION = "YResolution";
    @Deprecated
    public static final int WHITEBALANCE_AUTO = 0;
    @Deprecated
    public static final int WHITEBALANCE_MANUAL = 1;
    public static final short WHITE_BALANCE_AUTO = 0;
    public static final short WHITE_BALANCE_MANUAL = 1;
    public static final short Y_CB_CR_POSITIONING_CENTERED = 1;
    public static final short Y_CB_CR_POSITIONING_CO_SITED = 2;
    private static final HashMap<Integer, Integer> sExifPointerTagMap = new HashMap<>();
    private static final HashMap<Integer, ExifTag>[] sExifTagMapsForReading;
    private static final HashMap<String, ExifTag>[] sExifTagMapsForWriting;
    private static SimpleDateFormat sFormatter;
    private static final Pattern sGpsTimestampPattern = Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    private static final Pattern sNonZeroTimePattern = Pattern.compile(".*[1-9].*");
    private static final HashSet<String> sTagSetForCompatibility = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
    private final AssetManager.AssetInputStream mAssetInputStream;
    private final HashMap<String, ExifAttribute>[] mAttributes;
    private Set<Integer> mAttributesOffsets;
    private ByteOrder mExifByteOrder = ByteOrder.BIG_ENDIAN;
    private int mExifOffset;
    private final String mFilename;
    private boolean mHasThumbnail;
    private boolean mIsSupportedFile;
    private int mMimeType;
    private int mOrfMakerNoteOffset;
    private int mOrfThumbnailLength;
    private int mOrfThumbnailOffset;
    private int mRw2JpgFromRawOffset;
    private byte[] mThumbnailBytes;
    private int mThumbnailCompression;
    private int mThumbnailLength;
    private int mThumbnailOffset;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IfdType {
    }

    static {
        ExifTag[] exifTagArr = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", 255, 4), new ExifTag("ImageWidth", 256, 3, 4), new ExifTag("ImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("Orientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("SensorTopBorder", 4, 4), new ExifTag("SensorLeftBorder", 5, 4), new ExifTag("SensorBottomBorder", 6, 4), new ExifTag("SensorRightBorder", 7, 4), new ExifTag("ISO", 23, 3), new ExifTag("JpgFromRaw", 46, 7)};
        IFD_TIFF_TAGS = exifTagArr;
        ExifTag[] exifTagArr2 = {new ExifTag("ExposureTime", 33434, 5), new ExifTag("FNumber", 33437, 5), new ExifTag("ExposureProgram", 34850, 3), new ExifTag("SpectralSensitivity", 34852, 2), new ExifTag("PhotographicSensitivity", 34855, 3), new ExifTag("OECF", 34856, 7), new ExifTag("ExifVersion", 36864, 2), new ExifTag("DateTimeOriginal", 36867, 2), new ExifTag("DateTimeDigitized", 36868, 2), new ExifTag("ComponentsConfiguration", 37121, 7), new ExifTag("CompressedBitsPerPixel", 37122, 5), new ExifTag("ShutterSpeedValue", 37377, 10), new ExifTag("ApertureValue", 37378, 5), new ExifTag("BrightnessValue", 37379, 10), new ExifTag("ExposureBiasValue", 37380, 10), new ExifTag("MaxApertureValue", 37381, 5), new ExifTag("SubjectDistance", 37382, 5), new ExifTag("MeteringMode", 37383, 3), new ExifTag("LightSource", 37384, 3), new ExifTag("Flash", 37385, 3), new ExifTag("FocalLength", 37386, 5), new ExifTag("SubjectArea", 37396, 3), new ExifTag("MakerNote", 37500, 7), new ExifTag("UserComment", 37510, 7), new ExifTag("SubSecTime", 37520, 2), new ExifTag("SubSecTimeOriginal", 37521, 2), new ExifTag("SubSecTimeDigitized", 37522, 2), new ExifTag("FlashpixVersion", 40960, 7), new ExifTag("ColorSpace", 40961, 3), new ExifTag("PixelXDimension", 40962, 3, 4), new ExifTag("PixelYDimension", 40963, 3, 4), new ExifTag("RelatedSoundFile", 40964, 2), new ExifTag("InteroperabilityIFDPointer", 40965, 4), new ExifTag("FlashEnergy", 41483, 5), new ExifTag("SpatialFrequencyResponse", 41484, 7), new ExifTag("FocalPlaneXResolution", 41486, 5), new ExifTag("FocalPlaneYResolution", 41487, 5), new ExifTag("FocalPlaneResolutionUnit", 41488, 3), new ExifTag("SubjectLocation", 41492, 3), new ExifTag("ExposureIndex", 41493, 5), new ExifTag("SensingMethod", 41495, 3), new ExifTag("FileSource", 41728, 7), new ExifTag("SceneType", 41729, 7), new ExifTag("CFAPattern", 41730, 7), new ExifTag("CustomRendered", 41985, 3), new ExifTag("ExposureMode", 41986, 3), new ExifTag("WhiteBalance", 41987, 3), new ExifTag("DigitalZoomRatio", 41988, 5), new ExifTag("FocalLengthIn35mmFilm", 41989, 3), new ExifTag("SceneCaptureType", 41990, 3), new ExifTag("GainControl", 41991, 3), new ExifTag("Contrast", 41992, 3), new ExifTag("Saturation", 41993, 3), new ExifTag("Sharpness", 41994, 3), new ExifTag("DeviceSettingDescription", 41995, 7), new ExifTag("SubjectDistanceRange", 41996, 3), new ExifTag("ImageUniqueID", 42016, 2), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4)};
        IFD_EXIF_TAGS = exifTagArr2;
        ExifTag[] exifTagArr3 = {new ExifTag("GPSVersionID", 0, 1), new ExifTag("GPSLatitudeRef", 1, 2), new ExifTag("GPSLatitude", 2, 5), new ExifTag("GPSLongitudeRef", 3, 2), new ExifTag("GPSLongitude", 4, 5), new ExifTag("GPSAltitudeRef", 5, 1), new ExifTag("GPSAltitude", 6, 5), new ExifTag("GPSTimeStamp", 7, 5), new ExifTag("GPSSatellites", 8, 2), new ExifTag("GPSStatus", 9, 2), new ExifTag("GPSMeasureMode", 10, 2), new ExifTag("GPSDOP", 11, 5), new ExifTag("GPSSpeedRef", 12, 2), new ExifTag("GPSSpeed", 13, 5), new ExifTag("GPSTrackRef", 14, 2), new ExifTag("GPSTrack", 15, 5), new ExifTag("GPSImgDirectionRef", 16, 2), new ExifTag("GPSImgDirection", 17, 5), new ExifTag("GPSMapDatum", 18, 2), new ExifTag("GPSDestLatitudeRef", 19, 2), new ExifTag("GPSDestLatitude", 20, 5), new ExifTag("GPSDestLongitudeRef", 21, 2), new ExifTag("GPSDestLongitude", 22, 5), new ExifTag("GPSDestBearingRef", 23, 2), new ExifTag("GPSDestBearing", 24, 5), new ExifTag("GPSDestDistanceRef", 25, 2), new ExifTag("GPSDestDistance", 26, 5), new ExifTag("GPSProcessingMethod", 27, 7), new ExifTag("GPSAreaInformation", 28, 7), new ExifTag("GPSDateStamp", 29, 2), new ExifTag("GPSDifferential", 30, 3)};
        IFD_GPS_TAGS = exifTagArr3;
        ExifTag[] exifTagArr4 = {new ExifTag("InteroperabilityIndex", 1, 2)};
        IFD_INTEROPERABILITY_TAGS = exifTagArr4;
        ExifTag[] exifTagArr5 = {new ExifTag("NewSubfileType", 254, 4), new ExifTag("SubfileType", 255, 4), new ExifTag("ThumbnailImageWidth", 256, 3, 4), new ExifTag("ThumbnailImageLength", 257, 3, 4), new ExifTag("BitsPerSample", 258, 3), new ExifTag("Compression", 259, 3), new ExifTag("PhotometricInterpretation", 262, 3), new ExifTag("ImageDescription", 270, 2), new ExifTag("Make", 271, 2), new ExifTag("Model", 272, 2), new ExifTag("StripOffsets", 273, 3, 4), new ExifTag("Orientation", 274, 3), new ExifTag("SamplesPerPixel", 277, 3), new ExifTag("RowsPerStrip", 278, 3, 4), new ExifTag("StripByteCounts", 279, 3, 4), new ExifTag("XResolution", 282, 5), new ExifTag("YResolution", 283, 5), new ExifTag("PlanarConfiguration", 284, 3), new ExifTag("ResolutionUnit", 296, 3), new ExifTag("TransferFunction", 301, 3), new ExifTag("Software", 305, 2), new ExifTag("DateTime", 306, 2), new ExifTag("Artist", 315, 2), new ExifTag("WhitePoint", 318, 5), new ExifTag("PrimaryChromaticities", 319, 5), new ExifTag("SubIFDPointer", 330, 4), new ExifTag("JPEGInterchangeFormat", 513, 4), new ExifTag("JPEGInterchangeFormatLength", 514, 4), new ExifTag("YCbCrCoefficients", 529, 5), new ExifTag("YCbCrSubSampling", 530, 3), new ExifTag("YCbCrPositioning", 531, 3), new ExifTag("ReferenceBlackWhite", 532, 5), new ExifTag("Copyright", 33432, 2), new ExifTag("ExifIFDPointer", 34665, 4), new ExifTag("GPSInfoIFDPointer", 34853, 4), new ExifTag("DNGVersion", 50706, 1), new ExifTag("DefaultCropSize", 50720, 3, 4)};
        IFD_THUMBNAIL_TAGS = exifTagArr5;
        ExifTag[] exifTagArr6 = {new ExifTag("ThumbnailImage", 256, 7), new ExifTag("CameraSettingsIFDPointer", 8224, 4), new ExifTag("ImageProcessingIFDPointer", 8256, 4)};
        ORF_MAKER_NOTE_TAGS = exifTagArr6;
        ExifTag[] exifTagArr7 = {new ExifTag("PreviewImageStart", 257, 4), new ExifTag("PreviewImageLength", 258, 4)};
        ORF_CAMERA_SETTINGS_TAGS = exifTagArr7;
        ExifTag[] exifTagArr8 = {new ExifTag("AspectFrame", 4371, 3)};
        ORF_IMAGE_PROCESSING_TAGS = exifTagArr8;
        ExifTag[] exifTagArr9 = {new ExifTag("ColorSpace", 55, 3)};
        PEF_TAGS = exifTagArr9;
        ExifTag[][] exifTagArr10 = {exifTagArr, exifTagArr2, exifTagArr3, exifTagArr4, exifTagArr5, exifTagArr, exifTagArr6, exifTagArr7, exifTagArr8, exifTagArr9};
        EXIF_TAGS = exifTagArr10;
        sExifTagMapsForReading = new HashMap[exifTagArr10.length];
        sExifTagMapsForWriting = new HashMap[exifTagArr10.length];
        Charset forName = Charset.forName("US-ASCII");
        ASCII = forName;
        IDENTIFIER_EXIF_APP1 = "Exif\u0000\u0000".getBytes(forName);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        sFormatter = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            ExifTag[][] exifTagArr11 = EXIF_TAGS;
            if (i < exifTagArr11.length) {
                sExifTagMapsForReading[i] = new HashMap<>();
                sExifTagMapsForWriting[i] = new HashMap<>();
                ExifTag[] exifTagArr12 = exifTagArr11[i];
                for (ExifTag exifTag : exifTagArr12) {
                    sExifTagMapsForReading[i].put(Integer.valueOf(exifTag.number), exifTag);
                    sExifTagMapsForWriting[i].put(exifTag.name, exifTag);
                }
                i++;
            } else {
                HashMap<Integer, Integer> hashMap = sExifPointerTagMap;
                ExifTag[] exifTagArr13 = EXIF_POINTER_TAGS;
                hashMap.put(Integer.valueOf(exifTagArr13[0].number), 5);
                hashMap.put(Integer.valueOf(exifTagArr13[1].number), 1);
                hashMap.put(Integer.valueOf(exifTagArr13[2].number), 2);
                hashMap.put(Integer.valueOf(exifTagArr13[3].number), 3);
                hashMap.put(Integer.valueOf(exifTagArr13[4].number), 7);
                hashMap.put(Integer.valueOf(exifTagArr13[5].number), 8);
                return;
            }
        }
    }

    private static class Rational {
        public final long denominator;
        public final long numerator;

        Rational(double d) {
            this((long) (d * 10000.0d), 10000);
        }

        Rational(long j, long j2) {
            if (j2 == 0) {
                this.numerator = 0;
                this.denominator = 1;
                return;
            }
            this.numerator = j;
            this.denominator = j2;
        }

        public String toString() {
            return this.numerator + "/" + this.denominator;
        }

        public double calculate() {
            return ((double) this.numerator) / ((double) this.denominator);
        }
    }

    private static class ExifAttribute {
        public final byte[] bytes;
        public final int format;
        public final int numberOfComponents;

        ExifAttribute(int i, int i2, byte[] bArr) {
            this.format = i;
            this.numberOfComponents = i2;
            this.bytes = bArr;
        }

        public static ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putShort((short) i);
            }
            return new ExifAttribute(3, iArr.length, wrap.array());
        }

        public static ExifAttribute createUShort(int i, ByteOrder byteOrder) {
            return createUShort(new int[]{i}, byteOrder);
        }

        public static ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length)]);
            wrap.order(byteOrder);
            for (long j : jArr) {
                wrap.putInt((int) j);
            }
            return new ExifAttribute(4, jArr.length, wrap.array());
        }

        public static ExifAttribute createULong(long j, ByteOrder byteOrder) {
            return createULong(new long[]{j}, byteOrder);
        }

        public static ExifAttribute createSLong(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length)]);
            wrap.order(byteOrder);
            for (int i : iArr) {
                wrap.putInt(i);
            }
            return new ExifAttribute(9, iArr.length, wrap.array());
        }

        public static ExifAttribute createSLong(int i, ByteOrder byteOrder) {
            return createSLong(new int[]{i}, byteOrder);
        }

        public static ExifAttribute createByte(String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
            }
            byte[] bytes2 = str.getBytes(ExifInterface.ASCII);
            return new ExifAttribute(1, bytes2.length, bytes2);
        }

        public static ExifAttribute createString(String str) {
            byte[] bytes2 = (str + (char) 0).getBytes(ExifInterface.ASCII);
            return new ExifAttribute(2, bytes2.length, bytes2);
        }

        public static ExifAttribute createURational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(5, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createURational(Rational rational, ByteOrder byteOrder) {
            return createURational(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute createSRational(Rational[] rationalArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * rationalArr.length)]);
            wrap.order(byteOrder);
            for (Rational rational : rationalArr) {
                wrap.putInt((int) rational.numerator);
                wrap.putInt((int) rational.denominator);
            }
            return new ExifAttribute(10, rationalArr.length, wrap.array());
        }

        public static ExifAttribute createSRational(Rational rational, ByteOrder byteOrder) {
            return createSRational(new Rational[]{rational}, byteOrder);
        }

        public static ExifAttribute createDouble(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer wrap = ByteBuffer.wrap(new byte[(ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length)]);
            wrap.order(byteOrder);
            for (double d : dArr) {
                wrap.putDouble(d);
            }
            return new ExifAttribute(12, dArr.length, wrap.array());
        }

        public static ExifAttribute createDouble(double d, ByteOrder byteOrder) {
            return createDouble(new double[]{d}, byteOrder);
        }

        public String toString() {
            return "(" + ExifInterface.IFD_FORMAT_NAMES[this.format] + ", data length:" + this.bytes.length + ")";
        }

        /* JADX WARNING: Removed duplicated region for block: B:138:0x019a A[SYNTHETIC, Splitter:B:138:0x019a] */
        /* JADX WARNING: Removed duplicated region for block: B:146:0x01a7 A[SYNTHETIC, Splitter:B:146:0x01a7] */
        Object getValue(ByteOrder byteOrder) {
            Throwable th;
            IOException e;
            ByteOrderedDataInputStream byteOrderedDataInputStream;
            byte b;
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = null;
            try {
                byteOrderedDataInputStream = new ByteOrderedDataInputStream(this.bytes);
                try {
                    byteOrderedDataInputStream.setByteOrder(byteOrder);
                    boolean z = true;
                    int i = 0;
                    switch (this.format) {
                        case 1:
                        case 6:
                            byte[] bArr = this.bytes;
                            if (bArr.length != 1 || bArr[0] < 0 || bArr[0] > 1) {
                                String str = new String(this.bytes, ExifInterface.ASCII);
                                try {
                                    byteOrderedDataInputStream.close();
                                } catch (IOException e2) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e2);
                                }
                                return str;
                            }
                            String str2 = new String(new char[]{(char) (this.bytes[0] + 48)});
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e3) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e3);
                            }
                            return str2;
                        case 2:
                        case 7:
                            if (this.numberOfComponents >= ExifInterface.EXIF_ASCII_PREFIX.length) {
                                int i2 = 0;
                                while (true) {
                                    if (i2 < ExifInterface.EXIF_ASCII_PREFIX.length) {
                                        if (this.bytes[i2] != ExifInterface.EXIF_ASCII_PREFIX[i2]) {
                                            z = false;
                                        } else {
                                            i2++;
                                        }
                                    }
                                }
                                if (z) {
                                    i = ExifInterface.EXIF_ASCII_PREFIX.length;
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            while (i < this.numberOfComponents && (b = this.bytes[i]) != 0) {
                                if (b >= 32) {
                                    sb.append((char) b);
                                } else {
                                    sb.append('?');
                                }
                                i++;
                            }
                            String sb2 = sb.toString();
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e4) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e4);
                            }
                            return sb2;
                        case 3:
                            int[] iArr = new int[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                iArr[i] = byteOrderedDataInputStream.readUnsignedShort();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e5) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e5);
                            }
                            return iArr;
                        case 4:
                            long[] jArr = new long[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                jArr[i] = byteOrderedDataInputStream.readUnsignedInt();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e6) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                            }
                            return jArr;
                        case 5:
                            Rational[] rationalArr = new Rational[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                rationalArr[i] = new Rational(byteOrderedDataInputStream.readUnsignedInt(), byteOrderedDataInputStream.readUnsignedInt());
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e7) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e7);
                            }
                            return rationalArr;
                        case 8:
                            int[] iArr2 = new int[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                iArr2[i] = byteOrderedDataInputStream.readShort();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e8) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e8);
                            }
                            return iArr2;
                        case 9:
                            int[] iArr3 = new int[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                iArr3[i] = byteOrderedDataInputStream.readInt();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e9) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e9);
                            }
                            return iArr3;
                        case 10:
                            Rational[] rationalArr2 = new Rational[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                rationalArr2[i] = new Rational((long) byteOrderedDataInputStream.readInt(), (long) byteOrderedDataInputStream.readInt());
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e10) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e10);
                            }
                            return rationalArr2;
                        case 11:
                            double[] dArr = new double[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                dArr[i] = (double) byteOrderedDataInputStream.readFloat();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e11) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                            }
                            return dArr;
                        case 12:
                            double[] dArr2 = new double[this.numberOfComponents];
                            while (i < this.numberOfComponents) {
                                dArr2[i] = byteOrderedDataInputStream.readDouble();
                                i++;
                            }
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e12) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e12);
                            }
                            return dArr2;
                        default:
                            try {
                                byteOrderedDataInputStream.close();
                            } catch (IOException e13) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e13);
                            }
                            return null;
                    }
                } catch (IOException e14) {
                    e = e14;
                    try {
                        Log.w("ExifInterface", "IOException occurred during reading a value", e);
                        if (byteOrderedDataInputStream != null) {
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        byteOrderedDataInputStream2 = byteOrderedDataInputStream;
                        if (byteOrderedDataInputStream2 != null) {
                            try {
                                byteOrderedDataInputStream2.close();
                            } catch (IOException e15) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e15);
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e16) {
                e = e16;
                byteOrderedDataInputStream = null;
                Log.w("ExifInterface", "IOException occurred during reading a value", e);
                if (byteOrderedDataInputStream != null) {
                    try {
                        byteOrderedDataInputStream.close();
                    } catch (IOException e17) {
                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e17);
                    }
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (byteOrderedDataInputStream2 != null) {
                }
                throw th;
            }
        }

        public double getDoubleValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            } else if (value instanceof String) {
                return Double.parseDouble((String) value);
            } else {
                if (value instanceof long[]) {
                    long[] jArr = (long[]) value;
                    if (jArr.length == 1) {
                        return (double) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof int[]) {
                    int[] iArr = (int[]) value;
                    if (iArr.length == 1) {
                        return (double) iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof double[]) {
                    double[] dArr = (double[]) value;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof Rational[]) {
                    Rational[] rationalArr = (Rational[]) value;
                    if (rationalArr.length == 1) {
                        return rationalArr[0].calculate();
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
        }

        public int getIntValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            } else if (value instanceof String) {
                return Integer.parseInt((String) value);
            } else {
                if (value instanceof long[]) {
                    long[] jArr = (long[]) value;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (value instanceof int[]) {
                    int[] iArr = (int[]) value;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
        }

        public String getStringValue(ByteOrder byteOrder) {
            Object value = getValue(byteOrder);
            if (value == null) {
                return null;
            }
            if (value instanceof String) {
                return (String) value;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (value instanceof long[]) {
                long[] jArr = (long[]) value;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (value instanceof int[]) {
                int[] iArr = (int[]) value;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (value instanceof double[]) {
                double[] dArr = (double[]) value;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            } else if (!(value instanceof Rational[])) {
                return null;
            } else {
                Rational[] rationalArr = (Rational[]) value;
                while (i < rationalArr.length) {
                    sb.append(rationalArr[i].numerator);
                    sb.append('/');
                    sb.append(rationalArr[i].denominator);
                    i++;
                    if (i != rationalArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
        }

        public int size() {
            return ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
        }
    }

    static class ExifTag {
        public final String name;
        public final int number;
        public final int primaryFormat;
        public final int secondaryFormat;

        ExifTag(String str, int i, int i2) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = -1;
        }

        ExifTag(String str, int i, int i2, int i3) {
            this.name = str;
            this.number = i;
            this.primaryFormat = i2;
            this.secondaryFormat = i3;
        }

        boolean isFormatCompatible(int i) {
            int i2;
            int i3 = this.primaryFormat;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.secondaryFormat) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((i3 == 9 || i2 == 9) && i == 8) {
                return true;
            }
            if ((i3 == 12 || i2 == 12) && i == 11) {
                return true;
            }
            return false;
        }
    }

    public ExifInterface(String str) throws IOException {
        Throwable th;
        ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        if (str != null) {
            FileInputStream fileInputStream = null;
            this.mAssetInputStream = null;
            this.mFilename = str;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    loadAttributes(fileInputStream2);
                    closeQuietly(fileInputStream2);
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream = fileInputStream2;
                    closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                closeQuietly(fileInputStream);
                throw th;
            }
        } else {
            throw new IllegalArgumentException("filename cannot be null");
        }
    }

    public ExifInterface(InputStream inputStream) throws IOException {
        ExifTag[][] exifTagArr = EXIF_TAGS;
        this.mAttributes = new HashMap[exifTagArr.length];
        this.mAttributesOffsets = new HashSet(exifTagArr.length);
        if (inputStream != null) {
            this.mFilename = null;
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.mAssetInputStream = (AssetManager.AssetInputStream) inputStream;
            } else {
                this.mAssetInputStream = null;
            }
            loadAttributes(inputStream);
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null");
    }

    private ExifAttribute getExifAttribute(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            ExifAttribute exifAttribute = this.mAttributes[i].get(str);
            if (exifAttribute != null) {
                return exifAttribute;
            }
        }
        return null;
    }

    public String getAttribute(String str) {
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute != null) {
            if (!sTagSetForCompatibility.contains(str)) {
                return exifAttribute.getStringValue(this.mExifByteOrder);
            }
            if (!str.equals("GPSTimeStamp")) {
                try {
                    return Double.toString(exifAttribute.getDoubleValue(this.mExifByteOrder));
                } catch (NumberFormatException unused) {
                }
            } else if (exifAttribute.format == 5 || exifAttribute.format == 10) {
                Rational[] rationalArr = (Rational[]) exifAttribute.getValue(this.mExifByteOrder);
                if (rationalArr != null && rationalArr.length == 3) {
                    return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) rationalArr[0].numerator) / ((float) rationalArr[0].denominator))), Integer.valueOf((int) (((float) rationalArr[1].numerator) / ((float) rationalArr[1].denominator))), Integer.valueOf((int) (((float) rationalArr[2].numerator) / ((float) rationalArr[2].denominator))));
                }
                Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(rationalArr));
                return null;
            } else {
                Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + exifAttribute.format);
                return null;
            }
        }
        return null;
    }

    public int getAttributeInt(String str, int i) {
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute == null) {
            return i;
        }
        try {
            return exifAttribute.getIntValue(this.mExifByteOrder);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public double getAttributeDouble(String str, double d) {
        ExifAttribute exifAttribute = getExifAttribute(str);
        if (exifAttribute == null) {
            return d;
        }
        try {
            return exifAttribute.getDoubleValue(this.mExifByteOrder);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public void setAttribute(String str, String str2) {
        ExifTag exifTag;
        int i;
        String str3;
        String str4;
        String str5 = str2;
        String str6 = "ISOSpeedRatings".equals(str) ? "PhotographicSensitivity" : str;
        int i2 = 2;
        String str7 = "ExifInterface";
        int i3 = 1;
        if (str5 != null && sTagSetForCompatibility.contains(str6)) {
            if (str6.equals("GPSTimeStamp")) {
                Matcher matcher = sGpsTimestampPattern.matcher(str5);
                if (!matcher.find()) {
                    Log.w(str7, "Invalid value for " + str6 + " : " + str5);
                    return;
                }
                str5 = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    str5 = new Rational(Double.parseDouble(str2)).toString();
                } catch (NumberFormatException unused) {
                    Log.w(str7, "Invalid value for " + str6 + " : " + str5);
                    return;
                }
            }
        }
        char c = 0;
        int i4 = 0;
        while (i4 < EXIF_TAGS.length) {
            if ((i4 != 4 || this.mHasThumbnail) && (exifTag = sExifTagMapsForWriting[i4].get(str6)) != null) {
                if (str5 == null) {
                    this.mAttributes[i4].remove(str6);
                } else {
                    Pair<Integer, Integer> guessDataFormat = guessDataFormat(str5);
                    int i5 = -1;
                    if (exifTag.primaryFormat == ((Integer) guessDataFormat.first).intValue() || exifTag.primaryFormat == ((Integer) guessDataFormat.second).intValue()) {
                        i = exifTag.primaryFormat;
                    } else if (exifTag.secondaryFormat != -1 && (exifTag.secondaryFormat == ((Integer) guessDataFormat.first).intValue() || exifTag.secondaryFormat == ((Integer) guessDataFormat.second).intValue())) {
                        i = exifTag.secondaryFormat;
                    } else if (exifTag.primaryFormat == i3 || exifTag.primaryFormat == 7 || exifTag.primaryFormat == i2) {
                        i = exifTag.primaryFormat;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Given tag (");
                        sb.append(str6);
                        sb.append(") value didn't match with one of expected ");
                        sb.append("formats: ");
                        String[] strArr = IFD_FORMAT_NAMES;
                        sb.append(strArr[exifTag.primaryFormat]);
                        String str8 = "";
                        sb.append(exifTag.secondaryFormat == -1 ? str8 : ", " + strArr[exifTag.secondaryFormat]);
                        sb.append(" (guess: ");
                        sb.append(strArr[((Integer) guessDataFormat.first).intValue()]);
                        if (((Integer) guessDataFormat.second).intValue() != -1) {
                            str8 = ", " + strArr[((Integer) guessDataFormat.second).intValue()];
                        }
                        sb.append(str8);
                        sb.append(")");
                        Log.w(str7, sb.toString());
                    }
                    switch (i) {
                        case 1:
                            str3 = str7;
                            this.mAttributes[i4].put(str6, ExifAttribute.createByte(str5));
                            str7 = str3;
                            break;
                        case 2:
                        case 7:
                            str3 = str7;
                            this.mAttributes[i4].put(str6, ExifAttribute.createString(str5));
                            str7 = str3;
                            break;
                        case 3:
                            str3 = str7;
                            String[] split = str5.split(",", -1);
                            int[] iArr = new int[split.length];
                            for (int i6 = 0; i6 < split.length; i6++) {
                                iArr[i6] = Integer.parseInt(split[i6]);
                            }
                            this.mAttributes[i4].put(str6, ExifAttribute.createUShort(iArr, this.mExifByteOrder));
                            str7 = str3;
                            break;
                        case 4:
                            str3 = str7;
                            String[] split2 = str5.split(",", -1);
                            long[] jArr = new long[split2.length];
                            for (int i7 = 0; i7 < split2.length; i7++) {
                                jArr[i7] = Long.parseLong(split2[i7]);
                            }
                            this.mAttributes[i4].put(str6, ExifAttribute.createULong(jArr, this.mExifByteOrder));
                            str7 = str3;
                            break;
                        case 5:
                            str3 = str7;
                            String[] split3 = str5.split(",", -1);
                            Rational[] rationalArr = new Rational[split3.length];
                            int i8 = 0;
                            while (i8 < split3.length) {
                                String[] split4 = split3[i8].split("/", i5);
                                rationalArr[i8] = new Rational((long) Double.parseDouble(split4[0]), (long) Double.parseDouble(split4[1]));
                                i8++;
                                i5 = -1;
                            }
                            this.mAttributes[i4].put(str6, ExifAttribute.createURational(rationalArr, this.mExifByteOrder));
                            str7 = str3;
                            break;
                        case 6:
                        case 8:
                        case 11:
                        default:
                            str7 = str7;
                            Log.w(str7, "Data format isn't one of expected formats: " + i);
                            break;
                        case 9:
                            str4 = str7;
                            String[] split5 = str5.split(",", -1);
                            int[] iArr2 = new int[split5.length];
                            for (int i9 = 0; i9 < split5.length; i9++) {
                                iArr2[i9] = Integer.parseInt(split5[i9]);
                            }
                            this.mAttributes[i4].put(str6, ExifAttribute.createSLong(iArr2, this.mExifByteOrder));
                            str7 = str4;
                            break;
                        case 10:
                            String[] split6 = str5.split(",", -1);
                            Rational[] rationalArr2 = new Rational[split6.length];
                            int i10 = 0;
                            while (i10 < split6.length) {
                                String[] split7 = split6[i10].split("/", -1);
                                rationalArr2[i10] = new Rational((long) Double.parseDouble(split7[c]), (long) Double.parseDouble(split7[i3]));
                                i10++;
                                str7 = str7;
                                i3 = 1;
                                c = 0;
                            }
                            str4 = str7;
                            this.mAttributes[i4].put(str6, ExifAttribute.createSRational(rationalArr2, this.mExifByteOrder));
                            str7 = str4;
                            break;
                        case 12:
                            String[] split8 = str5.split(",", -1);
                            double[] dArr = new double[split8.length];
                            for (int i11 = 0; i11 < split8.length; i11++) {
                                dArr[i11] = Double.parseDouble(split8[i11]);
                            }
                            this.mAttributes[i4].put(str6, ExifAttribute.createDouble(dArr, this.mExifByteOrder));
                            break;
                    }
                    i4++;
                    i2 = 2;
                    i3 = 1;
                    c = 0;
                }
            }
            i4++;
            i2 = 2;
            i3 = 1;
            c = 0;
        }
    }

    public void resetOrientation() {
        setAttribute("Orientation", Integer.toString(1));
    }

    public void rotate(int i) {
        if (i % 90 == 0) {
            int attributeInt = getAttributeInt("Orientation", 1);
            List<Integer> list = ROTATION_ORDER;
            int i2 = 0;
            if (list.contains(Integer.valueOf(attributeInt))) {
                int indexOf = (list.indexOf(Integer.valueOf(attributeInt)) + (i / 90)) % 4;
                if (indexOf < 0) {
                    i2 = 4;
                }
                i2 = list.get(indexOf + i2).intValue();
            } else {
                List<Integer> list2 = FLIPPED_ROTATION_ORDER;
                if (list2.contains(Integer.valueOf(attributeInt))) {
                    int indexOf2 = (list2.indexOf(Integer.valueOf(attributeInt)) + (i / 90)) % 4;
                    if (indexOf2 < 0) {
                        i2 = 4;
                    }
                    i2 = list2.get(indexOf2 + i2).intValue();
                }
            }
            setAttribute("Orientation", Integer.toString(i2));
            return;
        }
        throw new IllegalArgumentException("degree should be a multiple of 90");
    }

    public void flipVertically() {
        int i = 1;
        switch (getAttributeInt("Orientation", 1)) {
            case 1:
                i = 4;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 2;
                break;
            case 4:
                break;
            case 5:
                i = 8;
                break;
            case 6:
                i = 7;
                break;
            case 7:
                i = 6;
                break;
            case 8:
                i = 5;
                break;
            default:
                i = 0;
                break;
        }
        setAttribute("Orientation", Integer.toString(i));
    }

    public void flipHorizontally() {
        int i = 1;
        switch (getAttributeInt("Orientation", 1)) {
            case 1:
                i = 2;
                break;
            case 2:
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 3;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 5;
                break;
            case 7:
                i = 8;
                break;
            case 8:
                i = 7;
                break;
            default:
                i = 0;
                break;
        }
        setAttribute("Orientation", Integer.toString(i));
    }

    public boolean isFlipped() {
        int attributeInt = getAttributeInt("Orientation", 1);
        return attributeInt == 2 || attributeInt == 7 || attributeInt == 4 || attributeInt == 5;
    }

    public int getRotationDegrees() {
        switch (getAttributeInt("Orientation", 1)) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 8:
                return 270;
            case 6:
            case 7:
                return 90;
            default:
                return 0;
        }
    }

    private boolean updateAttribute(String str, ExifAttribute exifAttribute) {
        boolean z = false;
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            if (this.mAttributes[i].containsKey(str)) {
                this.mAttributes[i].put(str, exifAttribute);
                z = true;
            }
        }
        return z;
    }

    private void removeAttribute(String str) {
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            this.mAttributes[i].remove(str);
        }
    }

    private void loadAttributes(InputStream inputStream) throws IOException {
        for (int i = 0; i < EXIF_TAGS.length; i++) {
            try {
                this.mAttributes[i] = new HashMap<>();
            } catch (IOException unused) {
                this.mIsSupportedFile = false;
            } catch (Throwable th) {
                addDefaultValuesForCompatibility();
                throw th;
            }
        }
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
        this.mMimeType = getMimeType(bufferedInputStream);
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bufferedInputStream);
        switch (this.mMimeType) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 5:
            case 6:
            case 8:
            case 11:
                getRawAttributes(byteOrderedDataInputStream);
                break;
            case 4:
                getJpegAttributes(byteOrderedDataInputStream, 0, 0);
                break;
            case 7:
                getOrfAttributes(byteOrderedDataInputStream);
                break;
            case 9:
                getRafAttributes(byteOrderedDataInputStream);
                break;
            case 10:
                getRw2Attributes(byteOrderedDataInputStream);
                break;
        }
        setThumbnailData(byteOrderedDataInputStream);
        this.mIsSupportedFile = true;
        addDefaultValuesForCompatibility();
    }

    private void printAttributes() {
        for (int i = 0; i < this.mAttributes.length; i++) {
            Log.d("ExifInterface", "The size of tag group[" + i + "]: " + this.mAttributes[i].size());
            for (Map.Entry<String, ExifAttribute> entry : this.mAttributes[i].entrySet()) {
                ExifAttribute value = entry.getValue();
                Log.d("ExifInterface", "tagName: " + entry.getKey() + ", tagType: " + value.toString() + ", tagValue: '" + value.getStringValue(this.mExifByteOrder) + "'");
            }
        }
    }

    public void saveAttributes() throws IOException {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        Throwable th;
        if (!this.mIsSupportedFile || this.mMimeType != 4) {
            throw new IOException("ExifInterface only supports saving attributes on JPEG formats.");
        } else if (this.mFilename != null) {
            this.mThumbnailBytes = getThumbnail();
            File file = new File(this.mFilename + ".tmp");
            if (new File(this.mFilename).renameTo(file)) {
                try {
                    fileInputStream = new FileInputStream(file);
                    try {
                        fileOutputStream = new FileOutputStream(this.mFilename);
                    } catch (Throwable th2) {
                        fileOutputStream = null;
                        th = th2;
                        closeQuietly(fileInputStream);
                        closeQuietly(fileOutputStream);
                        file.delete();
                        throw th;
                    }
                    try {
                        saveJpegAttributes(fileInputStream, fileOutputStream);
                        closeQuietly(fileInputStream);
                        closeQuietly(fileOutputStream);
                        file.delete();
                        this.mThumbnailBytes = null;
                    } catch (Throwable th3) {
                        th = th3;
                        closeQuietly(fileInputStream);
                        closeQuietly(fileOutputStream);
                        file.delete();
                        throw th;
                    }
                } catch (Throwable th4) {
                    fileOutputStream = null;
                    th = th4;
                    fileInputStream = null;
                    closeQuietly(fileInputStream);
                    closeQuietly(fileOutputStream);
                    file.delete();
                    throw th;
                }
            } else {
                throw new IOException("Could not rename to " + file.getAbsolutePath());
            }
        } else {
            throw new IOException("ExifInterface does not support saving attributes for the current input.");
        }
    }

    public boolean hasThumbnail() {
        return this.mHasThumbnail;
    }

    public byte[] getThumbnail() {
        int i = this.mThumbnailCompression;
        if (i == 6 || i == 7) {
            return getThumbnailBytes();
        }
        return null;
    }

    public byte[] getThumbnailBytes() {
        Throwable th;
        IOException e;
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (!this.mHasThumbnail) {
            return null;
        }
        byte[] bArr = this.mThumbnailBytes;
        if (bArr != null) {
            return bArr;
        }
        try {
            inputStream = this.mAssetInputStream;
            if (inputStream != null) {
                try {
                    if (inputStream.markSupported()) {
                        inputStream.reset();
                    } else {
                        Log.d("ExifInterface", "Cannot read thumbnail from inputstream without mark/reset support");
                        closeQuietly(inputStream);
                        return null;
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        Log.d("ExifInterface", "Encountered exception while getting thumbnail", e);
                        closeQuietly(inputStream);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream2 = inputStream;
                        closeQuietly(inputStream2);
                        throw th;
                    }
                }
            } else {
                inputStream = this.mFilename != null ? new FileInputStream(this.mFilename) : null;
            }
            if (inputStream == null) {
                throw new FileNotFoundException();
            } else if (inputStream.skip((long) this.mThumbnailOffset) == ((long) this.mThumbnailOffset)) {
                byte[] bArr2 = new byte[this.mThumbnailLength];
                if (inputStream.read(bArr2) == this.mThumbnailLength) {
                    this.mThumbnailBytes = bArr2;
                    closeQuietly(inputStream);
                    return bArr2;
                }
                throw new IOException("Corrupted image");
            } else {
                throw new IOException("Corrupted image");
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            Log.d("ExifInterface", "Encountered exception while getting thumbnail", e);
            closeQuietly(inputStream);
            return null;
        } catch (Throwable th3) {
            th = th3;
            closeQuietly(inputStream2);
            throw th;
        }
    }

    public Bitmap getThumbnailBitmap() {
        if (!this.mHasThumbnail) {
            return null;
        }
        if (this.mThumbnailBytes == null) {
            this.mThumbnailBytes = getThumbnailBytes();
        }
        int i = this.mThumbnailCompression;
        if (i == 6 || i == 7) {
            return BitmapFactory.decodeByteArray(this.mThumbnailBytes, 0, this.mThumbnailLength);
        }
        if (i == 1) {
            int length = this.mThumbnailBytes.length / 3;
            int[] iArr = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                byte[] bArr = this.mThumbnailBytes;
                int i3 = i2 * 3;
                iArr[i2] = (bArr[i3] << 16) + 0 + (bArr[i3 + 1] << 8) + bArr[i3 + 2];
            }
            ExifAttribute exifAttribute = this.mAttributes[4].get("ImageLength");
            ExifAttribute exifAttribute2 = this.mAttributes[4].get("ImageWidth");
            if (!(exifAttribute == null || exifAttribute2 == null)) {
                return Bitmap.createBitmap(iArr, exifAttribute2.getIntValue(this.mExifByteOrder), exifAttribute.getIntValue(this.mExifByteOrder), Bitmap.Config.ARGB_8888);
            }
        }
        return null;
    }

    public boolean isThumbnailCompressed() {
        int i = this.mThumbnailCompression;
        return i == 6 || i == 7;
    }

    public long[] getThumbnailRange() {
        if (!this.mHasThumbnail) {
            return null;
        }
        return new long[]{(long) this.mThumbnailOffset, (long) this.mThumbnailLength};
    }

    @Deprecated
    public boolean getLatLong(float[] fArr) {
        double[] latLong = getLatLong();
        if (latLong == null) {
            return false;
        }
        fArr[0] = (float) latLong[0];
        fArr[1] = (float) latLong[1];
        return true;
    }

    public double[] getLatLong() {
        String attribute = getAttribute("GPSLatitude");
        String attribute2 = getAttribute("GPSLatitudeRef");
        String attribute3 = getAttribute("GPSLongitude");
        String attribute4 = getAttribute("GPSLongitudeRef");
        if (attribute == null || attribute2 == null || attribute3 == null || attribute4 == null) {
            return null;
        }
        try {
            return new double[]{convertRationalLatLonToDouble(attribute, attribute2), convertRationalLatLonToDouble(attribute3, attribute4)};
        } catch (IllegalArgumentException unused) {
            Log.w("ExifInterface", "Latitude/longitude values are not parseable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", attribute, attribute2, attribute3, attribute4));
            return null;
        }
    }

    public void setGpsInfo(Location location) {
        if (location != null) {
            setAttribute("GPSProcessingMethod", location.getProvider());
            setLatLong(location.getLatitude(), location.getLongitude());
            setAltitude(location.getAltitude());
            setAttribute("GPSSpeedRef", "K");
            setAttribute("GPSSpeed", new Rational((double) ((location.getSpeed() * ((float) TimeUnit.HOURS.toSeconds(1))) / 1000.0f)).toString());
            String[] split = sFormatter.format(new Date(location.getTime())).split("\\s+", -1);
            setAttribute("GPSDateStamp", split[0]);
            setAttribute("GPSTimeStamp", split[1]);
        }
    }

    public void setLatLong(double d, double d2) {
        if (d < -90.0d || d > 90.0d || Double.isNaN(d)) {
            throw new IllegalArgumentException("Latitude value " + d + " is not valid.");
        } else if (d2 < -180.0d || d2 > 180.0d || Double.isNaN(d2)) {
            throw new IllegalArgumentException("Longitude value " + d2 + " is not valid.");
        } else {
            setAttribute("GPSLatitudeRef", d >= 0.0d ? "N" : "S");
            setAttribute("GPSLatitude", convertDecimalDegree(Math.abs(d)));
            setAttribute("GPSLongitudeRef", d2 >= 0.0d ? "E" : "W");
            setAttribute("GPSLongitude", convertDecimalDegree(Math.abs(d2)));
        }
    }

    public double getAltitude(double d) {
        double attributeDouble = getAttributeDouble("GPSAltitude", -1.0d);
        int i = -1;
        int attributeInt = getAttributeInt("GPSAltitudeRef", -1);
        if (attributeDouble < 0.0d || attributeInt < 0) {
            return d;
        }
        if (attributeInt != 1) {
            i = 1;
        }
        return attributeDouble * ((double) i);
    }

    public void setAltitude(double d) {
        String str = d >= 0.0d ? "0" : "1";
        setAttribute("GPSAltitude", new Rational(Math.abs(d)).toString());
        setAttribute("GPSAltitudeRef", str);
    }

    public void setDateTime(long j) {
        setAttribute("DateTime", sFormatter.format(new Date(j)));
        setAttribute("SubSecTime", Long.toString(j % 1000));
    }

    public long getDateTime() {
        String attribute = getAttribute("DateTime");
        if (attribute != null && sNonZeroTimePattern.matcher(attribute).matches()) {
            try {
                Date parse = sFormatter.parse(attribute, new ParsePosition(0));
                if (parse == null) {
                    return -1;
                }
                long time = parse.getTime();
                String attribute2 = getAttribute("SubSecTime");
                if (attribute2 == null) {
                    return time;
                }
                try {
                    long parseLong = Long.parseLong(attribute2);
                    while (parseLong > 1000) {
                        parseLong /= 10;
                    }
                    return time + parseLong;
                } catch (NumberFormatException unused) {
                    return time;
                }
            } catch (IllegalArgumentException unused2) {
            }
        }
        return -1;
    }

    public long getGpsDateTime() {
        String attribute = getAttribute("GPSDateStamp");
        String attribute2 = getAttribute("GPSTimeStamp");
        if (!(attribute == null || attribute2 == null)) {
            Pattern pattern = sNonZeroTimePattern;
            if (pattern.matcher(attribute).matches() || pattern.matcher(attribute2).matches()) {
                try {
                    Date parse = sFormatter.parse(attribute + ' ' + attribute2, new ParsePosition(0));
                    if (parse == null) {
                        return -1;
                    }
                    return parse.getTime();
                } catch (IllegalArgumentException unused) {
                }
            }
        }
        return -1;
    }

    private static double convertRationalLatLonToDouble(String str, String str2) {
        try {
            String[] split = str.split(",", -1);
            String[] split2 = split[0].split("/", -1);
            String[] split3 = split[1].split("/", -1);
            String[] split4 = split[2].split("/", -1);
            double parseDouble = (Double.parseDouble(split2[0].trim()) / Double.parseDouble(split2[1].trim())) + ((Double.parseDouble(split3[0].trim()) / Double.parseDouble(split3[1].trim())) / 60.0d) + ((Double.parseDouble(split4[0].trim()) / Double.parseDouble(split4[1].trim())) / 3600.0d);
            if (!str2.equals("S")) {
                if (!str2.equals("W")) {
                    if (!str2.equals("N")) {
                        if (!str2.equals("E")) {
                            throw new IllegalArgumentException();
                        }
                    }
                    return parseDouble;
                }
            }
            return -parseDouble;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    private String convertDecimalDegree(double d) {
        long j = (long) d;
        double d2 = d - ((double) j);
        long j2 = (long) (d2 * 60.0d);
        long round = Math.round((d2 - (((double) j2) / 60.0d)) * 3600.0d * 1.0E7d);
        return j + "/1," + j2 + "/1," + round + "/10000000";
    }

    private int getMimeType(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (isJpegFormat(bArr)) {
            return 4;
        }
        if (isRafFormat(bArr)) {
            return 9;
        }
        if (isOrfFormat(bArr)) {
            return 7;
        }
        return isRw2Format(bArr) ? 10 : 0;
    }

    private static boolean isJpegFormat(byte[] bArr) throws IOException {
        int i = 0;
        while (true) {
            byte[] bArr2 = JPEG_SIGNATURE;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean isRafFormat(byte[] bArr) throws IOException {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean isOrfFormat(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.setByteOrder(readByteOrder);
        short readShort = byteOrderedDataInputStream.readShort();
        byteOrderedDataInputStream.close();
        return readShort == 20306 || readShort == 21330;
    }

    private boolean isRw2Format(byte[] bArr) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.setByteOrder(readByteOrder);
        short readShort = byteOrderedDataInputStream.readShort();
        byteOrderedDataInputStream.close();
        return readShort == 85;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0057 A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f7 A[SYNTHETIC] */
    private void getJpegAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream, int i, int i2) throws IOException {
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        byteOrderedDataInputStream.seek((long) i);
        byte readByte = byteOrderedDataInputStream.readByte();
        if (readByte == -1) {
            int i3 = i + 1;
            if (byteOrderedDataInputStream.readByte() == -40) {
                int i4 = i3 + 1;
                while (true) {
                    byte readByte2 = byteOrderedDataInputStream.readByte();
                    if (readByte2 == -1) {
                        byte readByte3 = byteOrderedDataInputStream.readByte();
                        int i5 = i4 + 1 + 1;
                        if (readByte3 != -39 && readByte3 != -38) {
                            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort() - 2;
                            int i6 = i5 + 2;
                            if (readUnsignedShort >= 0) {
                                if (readByte3 == -31) {
                                    if (readUnsignedShort >= 6) {
                                        byte[] bArr = new byte[6];
                                        if (byteOrderedDataInputStream.read(bArr) == 6) {
                                            i6 += 6;
                                            readUnsignedShort -= 6;
                                            if (Arrays.equals(bArr, IDENTIFIER_EXIF_APP1)) {
                                                if (readUnsignedShort > 0) {
                                                    this.mExifOffset = i6;
                                                    byte[] bArr2 = new byte[readUnsignedShort];
                                                    if (byteOrderedDataInputStream.read(bArr2) == readUnsignedShort) {
                                                        i6 += readUnsignedShort;
                                                        readExifSegment(bArr2, i2);
                                                    } else {
                                                        throw new IOException("Invalid exif");
                                                    }
                                                } else {
                                                    throw new IOException("Invalid exif");
                                                }
                                            }
                                        } else {
                                            throw new IOException("Invalid exif");
                                        }
                                    }
                                    if (readUnsignedShort < 0) {
                                    }
                                } else if (readByte3 != -2) {
                                    switch (readByte3) {
                                        default:
                                            switch (readByte3) {
                                                default:
                                                    switch (readByte3) {
                                                        default:
                                                            switch (readByte3) {
                                                            }
                                                        case -55:
                                                        case -54:
                                                        case -53:
                                                            if (byteOrderedDataInputStream.skipBytes(1) == 1) {
                                                                this.mAttributes[i2].put("ImageLength", ExifAttribute.createULong((long) byteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
                                                                this.mAttributes[i2].put("ImageWidth", ExifAttribute.createULong((long) byteOrderedDataInputStream.readUnsignedShort(), this.mExifByteOrder));
                                                                readUnsignedShort -= 5;
                                                                break;
                                                            } else {
                                                                throw new IOException("Invalid SOFx");
                                                            }
                                                    }
                                                case -59:
                                                case -58:
                                                case -57:
                                                    break;
                                            }
                                        case -64:
                                        case -63:
                                        case -62:
                                        case -61:
                                            break;
                                    }
                                    if (readUnsignedShort < 0) {
                                        throw new IOException("Invalid length");
                                    } else if (byteOrderedDataInputStream.skipBytes(readUnsignedShort) == readUnsignedShort) {
                                        i4 = i6 + readUnsignedShort;
                                    } else {
                                        throw new IOException("Invalid JPEG segment");
                                    }
                                } else {
                                    byte[] bArr3 = new byte[readUnsignedShort];
                                    if (byteOrderedDataInputStream.read(bArr3) != readUnsignedShort) {
                                        throw new IOException("Invalid exif");
                                    } else if (getAttribute("UserComment") == null) {
                                        this.mAttributes[1].put("UserComment", ExifAttribute.createString(new String(bArr3, ASCII)));
                                    }
                                }
                                readUnsignedShort = 0;
                                if (readUnsignedShort < 0) {
                                }
                            } else {
                                throw new IOException("Invalid length");
                            }
                        }
                    } else {
                        throw new IOException("Invalid marker:" + Integer.toHexString(readByte2 & 255));
                    }
                }
                byteOrderedDataInputStream.setByteOrder(this.mExifByteOrder);
                return;
            }
            throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
        }
        throw new IOException("Invalid marker: " + Integer.toHexString(readByte & 255));
    }

    private void getRawAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        ExifAttribute exifAttribute;
        parseTiffHeaders(byteOrderedDataInputStream, byteOrderedDataInputStream.available());
        readImageFileDirectory(byteOrderedDataInputStream, 0);
        updateImageSizeValues(byteOrderedDataInputStream, 0);
        updateImageSizeValues(byteOrderedDataInputStream, 5);
        updateImageSizeValues(byteOrderedDataInputStream, 4);
        validateImages(byteOrderedDataInputStream);
        if (this.mMimeType == 8 && (exifAttribute = this.mAttributes[1].get("MakerNote")) != null) {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
            byteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byteOrderedDataInputStream2.seek(6);
            readImageFileDirectory(byteOrderedDataInputStream2, 9);
            ExifAttribute exifAttribute2 = this.mAttributes[9].get("ColorSpace");
            if (exifAttribute2 != null) {
                this.mAttributes[1].put("ColorSpace", exifAttribute2);
            }
        }
    }

    private void getRafAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        byteOrderedDataInputStream.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byteOrderedDataInputStream.read(bArr);
        byteOrderedDataInputStream.skipBytes(4);
        byteOrderedDataInputStream.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        getJpegAttributes(byteOrderedDataInputStream, i, 5);
        byteOrderedDataInputStream.seek((long) i2);
        byteOrderedDataInputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        int readInt = byteOrderedDataInputStream.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
            int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
            if (readUnsignedShort == TAG_RAF_IMAGE_SIZE.number) {
                short readShort = byteOrderedDataInputStream.readShort();
                short readShort2 = byteOrderedDataInputStream.readShort();
                ExifAttribute createUShort = ExifAttribute.createUShort(readShort, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort(readShort2, this.mExifByteOrder);
                this.mAttributes[0].put("ImageLength", createUShort);
                this.mAttributes[0].put("ImageWidth", createUShort2);
                return;
            }
            byteOrderedDataInputStream.skipBytes(readUnsignedShort2);
        }
    }

    private void getOrfAttributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        getRawAttributes(byteOrderedDataInputStream);
        ExifAttribute exifAttribute = this.mAttributes[1].get("MakerNote");
        if (exifAttribute != null) {
            ByteOrderedDataInputStream byteOrderedDataInputStream2 = new ByteOrderedDataInputStream(exifAttribute.bytes);
            byteOrderedDataInputStream2.setByteOrder(this.mExifByteOrder);
            byte[] bArr = ORF_MAKER_NOTE_HEADER_1;
            byte[] bArr2 = new byte[bArr.length];
            byteOrderedDataInputStream2.readFully(bArr2);
            byteOrderedDataInputStream2.seek(0);
            byte[] bArr3 = ORF_MAKER_NOTE_HEADER_2;
            byte[] bArr4 = new byte[bArr3.length];
            byteOrderedDataInputStream2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                byteOrderedDataInputStream2.seek(8);
            } else if (Arrays.equals(bArr4, bArr3)) {
                byteOrderedDataInputStream2.seek(12);
            }
            readImageFileDirectory(byteOrderedDataInputStream2, 6);
            ExifAttribute exifAttribute2 = this.mAttributes[7].get("PreviewImageStart");
            ExifAttribute exifAttribute3 = this.mAttributes[7].get("PreviewImageLength");
            if (!(exifAttribute2 == null || exifAttribute3 == null)) {
                this.mAttributes[5].put("JPEGInterchangeFormat", exifAttribute2);
                this.mAttributes[5].put("JPEGInterchangeFormatLength", exifAttribute3);
            }
            ExifAttribute exifAttribute4 = this.mAttributes[8].get("AspectFrame");
            if (exifAttribute4 != null) {
                int[] iArr = (int[]) exifAttribute4.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                } else if (iArr[2] > iArr[0] && iArr[3] > iArr[1]) {
                    int i = (iArr[2] - iArr[0]) + 1;
                    int i2 = (iArr[3] - iArr[1]) + 1;
                    if (i < i2) {
                        int i3 = i + i2;
                        i2 = i3 - i2;
                        i = i3 - i2;
                    }
                    ExifAttribute createUShort = ExifAttribute.createUShort(i, this.mExifByteOrder);
                    ExifAttribute createUShort2 = ExifAttribute.createUShort(i2, this.mExifByteOrder);
                    this.mAttributes[0].put("ImageWidth", createUShort);
                    this.mAttributes[0].put("ImageLength", createUShort2);
                }
            }
        }
    }

    private void getRw2Attributes(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        getRawAttributes(byteOrderedDataInputStream);
        if (this.mAttributes[0].get("JpgFromRaw") != null) {
            getJpegAttributes(byteOrderedDataInputStream, this.mRw2JpgFromRawOffset, 5);
        }
        ExifAttribute exifAttribute = this.mAttributes[0].get("ISO");
        ExifAttribute exifAttribute2 = this.mAttributes[1].get("PhotographicSensitivity");
        if (exifAttribute != null && exifAttribute2 == null) {
            this.mAttributes[1].put("PhotographicSensitivity", exifAttribute);
        }
    }

    private void saveJpegAttributes(InputStream inputStream, OutputStream outputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        ByteOrderedDataOutputStream byteOrderedDataOutputStream = new ByteOrderedDataOutputStream(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() == -1) {
            byteOrderedDataOutputStream.writeByte(-1);
            if (dataInputStream.readByte() == -40) {
                byteOrderedDataOutputStream.writeByte(-40);
                byteOrderedDataOutputStream.writeByte(-1);
                byteOrderedDataOutputStream.writeByte(-31);
                writeExifSegment(byteOrderedDataOutputStream, 6);
                byte[] bArr = new byte[4096];
                while (dataInputStream.readByte() == -1) {
                    byte readByte = dataInputStream.readByte();
                    if (readByte == -39 || readByte == -38) {
                        byteOrderedDataOutputStream.writeByte(-1);
                        byteOrderedDataOutputStream.writeByte(readByte);
                        copy(dataInputStream, byteOrderedDataOutputStream);
                        return;
                    } else if (readByte != -31) {
                        byteOrderedDataOutputStream.writeByte(-1);
                        byteOrderedDataOutputStream.writeByte(readByte);
                        int readUnsignedShort = dataInputStream.readUnsignedShort();
                        byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort);
                        int i = readUnsignedShort - 2;
                        if (i >= 0) {
                            while (i > 0) {
                                int read = dataInputStream.read(bArr, 0, Math.min(i, 4096));
                                if (read < 0) {
                                    break;
                                }
                                byteOrderedDataOutputStream.write(bArr, 0, read);
                                i -= read;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    } else {
                        int readUnsignedShort2 = dataInputStream.readUnsignedShort() - 2;
                        if (readUnsignedShort2 >= 0) {
                            byte[] bArr2 = new byte[6];
                            if (readUnsignedShort2 >= 6) {
                                if (dataInputStream.read(bArr2) != 6) {
                                    throw new IOException("Invalid exif");
                                } else if (Arrays.equals(bArr2, IDENTIFIER_EXIF_APP1)) {
                                    int i2 = readUnsignedShort2 - 6;
                                    if (dataInputStream.skipBytes(i2) != i2) {
                                        throw new IOException("Invalid length");
                                    }
                                }
                            }
                            byteOrderedDataOutputStream.writeByte(-1);
                            byteOrderedDataOutputStream.writeByte(readByte);
                            byteOrderedDataOutputStream.writeUnsignedShort(readUnsignedShort2 + 2);
                            if (readUnsignedShort2 >= 6) {
                                readUnsignedShort2 -= 6;
                                byteOrderedDataOutputStream.write(bArr2);
                            }
                            while (readUnsignedShort2 > 0) {
                                int read2 = dataInputStream.read(bArr, 0, Math.min(readUnsignedShort2, 4096));
                                if (read2 < 0) {
                                    break;
                                }
                                byteOrderedDataOutputStream.write(bArr, 0, read2);
                                readUnsignedShort2 -= read2;
                            }
                        } else {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                throw new IOException("Invalid marker");
            }
            throw new IOException("Invalid marker");
        }
        throw new IOException("Invalid marker");
    }

    private void readExifSegment(byte[] bArr, int i) throws IOException {
        ByteOrderedDataInputStream byteOrderedDataInputStream = new ByteOrderedDataInputStream(bArr);
        parseTiffHeaders(byteOrderedDataInputStream, bArr.length);
        readImageFileDirectory(byteOrderedDataInputStream, i);
    }

    private void addDefaultValuesForCompatibility() {
        String attribute = getAttribute("DateTimeOriginal");
        if (attribute != null && getAttribute("DateTime") == null) {
            this.mAttributes[0].put("DateTime", ExifAttribute.createString(attribute));
        }
        if (getAttribute("ImageWidth") == null) {
            this.mAttributes[0].put("ImageWidth", ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute("ImageLength") == null) {
            this.mAttributes[0].put("ImageLength", ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute("Orientation") == null) {
            this.mAttributes[0].put("Orientation", ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (getAttribute("LightSource") == null) {
            this.mAttributes[1].put("LightSource", ExifAttribute.createULong(0, this.mExifByteOrder));
        }
    }

    private ByteOrder readByteOrder(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        short readShort = byteOrderedDataInputStream.readShort();
        if (readShort == 18761) {
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (readShort == 19789) {
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(readShort));
    }

    private void parseTiffHeaders(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
        ByteOrder readByteOrder = readByteOrder(byteOrderedDataInputStream);
        this.mExifByteOrder = readByteOrder;
        byteOrderedDataInputStream.setByteOrder(readByteOrder);
        int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
        int i2 = this.mMimeType;
        if (i2 == 7 || i2 == 10 || readUnsignedShort == 42) {
            int readInt = byteOrderedDataInputStream.readInt();
            if (readInt < 8 || readInt >= i) {
                throw new IOException("Invalid first Ifd offset: " + readInt);
            }
            int i3 = readInt - 8;
            if (i3 > 0 && byteOrderedDataInputStream.skipBytes(i3) != i3) {
                throw new IOException("Couldn't jump to first Ifd: " + i3);
            }
            return;
        }
        throw new IOException("Invalid start code: " + Integer.toHexString(readUnsignedShort));
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f4  */
    private void readImageFileDirectory(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
        short s;
        boolean z;
        String str;
        long j;
        short s2;
        int i2;
        int i3;
        ExifTag exifTag;
        int i4;
        long j2;
        this.mAttributesOffsets.add(Integer.valueOf(byteOrderedDataInputStream.mPosition));
        if (byteOrderedDataInputStream.mPosition + 2 <= byteOrderedDataInputStream.mLength) {
            short readShort = byteOrderedDataInputStream.readShort();
            if (byteOrderedDataInputStream.mPosition + (readShort * 12) <= byteOrderedDataInputStream.mLength && readShort > 0) {
                short s3 = 0;
                while (s3 < readShort) {
                    int readUnsignedShort = byteOrderedDataInputStream.readUnsignedShort();
                    int readUnsignedShort2 = byteOrderedDataInputStream.readUnsignedShort();
                    int readInt = byteOrderedDataInputStream.readInt();
                    long peek = ((long) byteOrderedDataInputStream.peek()) + 4;
                    ExifTag exifTag2 = sExifTagMapsForReading[i].get(Integer.valueOf(readUnsignedShort));
                    if (exifTag2 == null) {
                        Log.w("ExifInterface", "Skip the tag entry since tag number is not defined: " + readUnsignedShort);
                    } else {
                        if (readUnsignedShort2 > 0) {
                            int[] iArr = IFD_FORMAT_BYTES_PER_FORMAT;
                            if (readUnsignedShort2 < iArr.length) {
                                if (!exifTag2.isFormatCompatible(readUnsignedShort2)) {
                                    Log.w("ExifInterface", "Skip the tag entry since data format (" + IFD_FORMAT_NAMES[readUnsignedShort2] + ") is unexpected for tag: " + exifTag2.name);
                                } else {
                                    if (readUnsignedShort2 == 7) {
                                        readUnsignedShort2 = exifTag2.primaryFormat;
                                    }
                                    str = "ExifInterface";
                                    s = s3;
                                    j = ((long) iArr[readUnsignedShort2]) * ((long) readInt);
                                    if (j < 0 || j > 2147483647L) {
                                        Log.w(str, "Skip the tag entry since the number of components is invalid: " + readInt);
                                        z = false;
                                        if (z) {
                                            byteOrderedDataInputStream.seek(peek);
                                            s2 = readShort;
                                        } else {
                                            if (j > 4) {
                                                int readInt2 = byteOrderedDataInputStream.readInt();
                                                int i5 = this.mMimeType;
                                                s2 = readShort;
                                                if (i5 == 7) {
                                                    if ("MakerNote".equals(exifTag2.name)) {
                                                        this.mOrfMakerNoteOffset = readInt2;
                                                    } else if (i == 6 && "ThumbnailImage".equals(exifTag2.name)) {
                                                        this.mOrfThumbnailOffset = readInt2;
                                                        this.mOrfThumbnailLength = readInt;
                                                        ExifAttribute createUShort = ExifAttribute.createUShort(6, this.mExifByteOrder);
                                                        i2 = readUnsignedShort2;
                                                        i3 = readInt;
                                                        ExifAttribute createULong = ExifAttribute.createULong((long) this.mOrfThumbnailOffset, this.mExifByteOrder);
                                                        j2 = peek;
                                                        ExifAttribute createULong2 = ExifAttribute.createULong((long) this.mOrfThumbnailLength, this.mExifByteOrder);
                                                        this.mAttributes[4].put("Compression", createUShort);
                                                        this.mAttributes[4].put("JPEGInterchangeFormat", createULong);
                                                        this.mAttributes[4].put("JPEGInterchangeFormatLength", createULong2);
                                                    }
                                                    i2 = readUnsignedShort2;
                                                    i3 = readInt;
                                                    j2 = peek;
                                                } else {
                                                    i2 = readUnsignedShort2;
                                                    i3 = readInt;
                                                    j2 = peek;
                                                    if (i5 == 10 && "JpgFromRaw".equals(exifTag2.name)) {
                                                        this.mRw2JpgFromRawOffset = readInt2;
                                                    }
                                                }
                                                long j3 = (long) readInt2;
                                                exifTag = exifTag2;
                                                if (j3 + j <= ((long) byteOrderedDataInputStream.mLength)) {
                                                    byteOrderedDataInputStream.seek(j3);
                                                    peek = j2;
                                                } else {
                                                    Log.w(str, "Skip the tag entry since data offset is invalid: " + readInt2);
                                                    byteOrderedDataInputStream.seek(j2);
                                                }
                                            } else {
                                                s2 = readShort;
                                                exifTag = exifTag2;
                                                i2 = readUnsignedShort2;
                                                i3 = readInt;
                                            }
                                            Integer num = sExifPointerTagMap.get(Integer.valueOf(readUnsignedShort));
                                            if (num != null) {
                                                long j4 = -1;
                                                if (i2 == 3) {
                                                    i4 = byteOrderedDataInputStream.readUnsignedShort();
                                                    j4 = (long) i4;
                                                } else if (i2 != 4) {
                                                    if (i2 == 8) {
                                                        i4 = byteOrderedDataInputStream.readShort();
                                                    } else if (i2 == 9 || i2 == 13) {
                                                        i4 = byteOrderedDataInputStream.readInt();
                                                    }
                                                    j4 = (long) i4;
                                                } else {
                                                    j4 = byteOrderedDataInputStream.readUnsignedInt();
                                                }
                                                if (j4 <= 0 || j4 >= ((long) byteOrderedDataInputStream.mLength)) {
                                                    Log.w(str, "Skip jump into the IFD since its offset is invalid: " + j4);
                                                } else if (!this.mAttributesOffsets.contains(Integer.valueOf((int) j4))) {
                                                    byteOrderedDataInputStream.seek(j4);
                                                    readImageFileDirectory(byteOrderedDataInputStream, num.intValue());
                                                } else {
                                                    Log.w(str, "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + j4 + ")");
                                                }
                                                byteOrderedDataInputStream.seek(peek);
                                            } else {
                                                byte[] bArr = new byte[((int) j)];
                                                byteOrderedDataInputStream.readFully(bArr);
                                                ExifAttribute exifAttribute = new ExifAttribute(i2, i3, bArr);
                                                this.mAttributes[i].put(exifTag.name, exifAttribute);
                                                if ("DNGVersion".equals(exifTag.name)) {
                                                    this.mMimeType = 3;
                                                }
                                                if ((("Make".equals(exifTag.name) || "Model".equals(exifTag.name)) && exifAttribute.getStringValue(this.mExifByteOrder).contains("PENTAX")) || ("Compression".equals(exifTag.name) && exifAttribute.getIntValue(this.mExifByteOrder) == 65535)) {
                                                    this.mMimeType = 8;
                                                }
                                                if (((long) byteOrderedDataInputStream.peek()) != peek) {
                                                    byteOrderedDataInputStream.seek(peek);
                                                }
                                            }
                                        }
                                        s3 = (short) (s + 1);
                                        readShort = s2;
                                    } else {
                                        z = true;
                                        if (z) {
                                        }
                                        s3 = (short) (s + 1);
                                        readShort = s2;
                                    }
                                }
                            }
                        }
                        s = s3;
                        str = "ExifInterface";
                        Log.w(str, "Skip the tag entry since data format is invalid: " + readUnsignedShort2);
                        j = 0;
                        z = false;
                        if (z) {
                        }
                        s3 = (short) (s + 1);
                        readShort = s2;
                    }
                    s = s3;
                    str = "ExifInterface";
                    j = 0;
                    z = false;
                    if (z) {
                    }
                    s3 = (short) (s + 1);
                    readShort = s2;
                }
                if (byteOrderedDataInputStream.peek() + 4 <= byteOrderedDataInputStream.mLength) {
                    int readInt3 = byteOrderedDataInputStream.readInt();
                    long j5 = (long) readInt3;
                    if (j5 <= 0 || readInt3 >= byteOrderedDataInputStream.mLength) {
                        Log.w("ExifInterface", "Stop reading file since a wrong offset may cause an infinite loop: " + readInt3);
                    } else if (!this.mAttributesOffsets.contains(Integer.valueOf(readInt3))) {
                        byteOrderedDataInputStream.seek(j5);
                        if (this.mAttributes[4].isEmpty()) {
                            readImageFileDirectory(byteOrderedDataInputStream, 4);
                        } else if (this.mAttributes[5].isEmpty()) {
                            readImageFileDirectory(byteOrderedDataInputStream, 5);
                        }
                    } else {
                        Log.w("ExifInterface", "Stop reading file since re-reading an IFD may cause an infinite loop: " + readInt3);
                    }
                }
            }
        }
    }

    private void retrieveJpegImageSize(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2 = this.mAttributes[i].get("ImageLength");
        ExifAttribute exifAttribute3 = this.mAttributes[i].get("ImageWidth");
        if ((exifAttribute2 == null || exifAttribute3 == null) && (exifAttribute = this.mAttributes[i].get("JPEGInterchangeFormat")) != null) {
            getJpegAttributes(byteOrderedDataInputStream, exifAttribute.getIntValue(this.mExifByteOrder), i);
        }
    }

    private void setThumbnailData(ByteOrderedDataInputStream byteOrderedDataInputStream) throws IOException {
        HashMap<String, ExifAttribute> hashMap = this.mAttributes[4];
        ExifAttribute exifAttribute = hashMap.get("Compression");
        if (exifAttribute != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            this.mThumbnailCompression = intValue;
            if (intValue != 1) {
                if (intValue == 6) {
                    handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
                    return;
                } else if (intValue != 7) {
                    return;
                }
            }
            if (isSupportedDataType(hashMap)) {
                handleThumbnailFromStrips(byteOrderedDataInputStream, hashMap);
                return;
            }
            return;
        }
        this.mThumbnailCompression = 6;
        handleThumbnailFromJfif(byteOrderedDataInputStream, hashMap);
    }

    private void handleThumbnailFromJfif(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        int i;
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("JPEGInterchangeFormat");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("JPEGInterchangeFormatLength");
        if (exifAttribute != null && exifAttribute2 != null) {
            int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
            int min = Math.min(exifAttribute2.getIntValue(this.mExifByteOrder), byteOrderedDataInputStream.available() - intValue);
            int i2 = this.mMimeType;
            if (i2 == 4 || i2 == 9 || i2 == 10) {
                i = this.mExifOffset;
            } else {
                if (i2 == 7) {
                    i = this.mOrfMakerNoteOffset;
                }
                if (intValue > 0 && min > 0) {
                    this.mHasThumbnail = true;
                    this.mThumbnailOffset = intValue;
                    this.mThumbnailLength = min;
                    if (this.mFilename == null && this.mAssetInputStream == null) {
                        byte[] bArr = new byte[min];
                        byteOrderedDataInputStream.seek((long) intValue);
                        byteOrderedDataInputStream.readFully(bArr);
                        this.mThumbnailBytes = bArr;
                        return;
                    }
                    return;
                }
            }
            intValue += i;
            if (intValue > 0) {
            }
        }
    }

    private void handleThumbnailFromStrips(ByteOrderedDataInputStream byteOrderedDataInputStream, HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("StripOffsets");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("StripByteCounts");
        if (exifAttribute != null && exifAttribute2 != null) {
            long[] convertToLongArray = convertToLongArray(exifAttribute.getValue(this.mExifByteOrder));
            long[] convertToLongArray2 = convertToLongArray(exifAttribute2.getValue(this.mExifByteOrder));
            if (convertToLongArray == null) {
                Log.w("ExifInterface", "stripOffsets should not be null.");
            } else if (convertToLongArray2 == null) {
                Log.w("ExifInterface", "stripByteCounts should not be null.");
            } else {
                long j = 0;
                for (long j2 : convertToLongArray2) {
                    j += j2;
                }
                int i = (int) j;
                byte[] bArr = new byte[i];
                int i2 = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < convertToLongArray.length; i4++) {
                    int i5 = (int) convertToLongArray[i4];
                    int i6 = (int) convertToLongArray2[i4];
                    int i7 = i5 - i2;
                    if (i7 < 0) {
                        Log.d("ExifInterface", "Invalid strip offset value");
                    }
                    byteOrderedDataInputStream.seek((long) i7);
                    int i8 = i2 + i7;
                    byte[] bArr2 = new byte[i6];
                    byteOrderedDataInputStream.read(bArr2);
                    i2 = i8 + i6;
                    System.arraycopy(bArr2, 0, bArr, i3, i6);
                    i3 += i6;
                }
                this.mHasThumbnail = true;
                this.mThumbnailBytes = bArr;
                this.mThumbnailLength = i;
            }
        }
    }

    private boolean isSupportedDataType(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("BitsPerSample");
        if (exifAttribute2 == null) {
            return false;
        }
        int[] iArr = (int[]) exifAttribute2.getValue(this.mExifByteOrder);
        int[] iArr2 = BITS_PER_SAMPLE_RGB;
        if (Arrays.equals(iArr2, iArr)) {
            return true;
        }
        if (this.mMimeType != 3 || (exifAttribute = (ExifAttribute) hashMap.get("PhotometricInterpretation")) == null) {
            return false;
        }
        int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
        if ((intValue != 1 || !Arrays.equals(iArr, BITS_PER_SAMPLE_GREYSCALE_2)) && (intValue != 6 || !Arrays.equals(iArr, iArr2))) {
            return false;
        }
        return true;
    }

    private boolean isThumbnail(HashMap hashMap) throws IOException {
        ExifAttribute exifAttribute = (ExifAttribute) hashMap.get("ImageLength");
        ExifAttribute exifAttribute2 = (ExifAttribute) hashMap.get("ImageWidth");
        if (exifAttribute == null || exifAttribute2 == null) {
            return false;
        }
        return exifAttribute.getIntValue(this.mExifByteOrder) <= 512 && exifAttribute2.getIntValue(this.mExifByteOrder) <= 512;
    }

    private void validateImages(InputStream inputStream) throws IOException {
        swapBasedOnImageSize(0, 5);
        swapBasedOnImageSize(0, 4);
        swapBasedOnImageSize(5, 4);
        ExifAttribute exifAttribute = this.mAttributes[1].get("PixelXDimension");
        ExifAttribute exifAttribute2 = this.mAttributes[1].get("PixelYDimension");
        if (!(exifAttribute == null || exifAttribute2 == null)) {
            this.mAttributes[0].put("ImageWidth", exifAttribute);
            this.mAttributes[0].put("ImageLength", exifAttribute2);
        }
        if (this.mAttributes[4].isEmpty() && isThumbnail(this.mAttributes[5])) {
            HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!isThumbnail(this.mAttributes[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
    }

    private void updateImageSizeValues(ByteOrderedDataInputStream byteOrderedDataInputStream, int i) throws IOException {
        ExifAttribute exifAttribute;
        ExifAttribute exifAttribute2;
        ExifAttribute exifAttribute3 = this.mAttributes[i].get("DefaultCropSize");
        ExifAttribute exifAttribute4 = this.mAttributes[i].get("SensorTopBorder");
        ExifAttribute exifAttribute5 = this.mAttributes[i].get("SensorLeftBorder");
        ExifAttribute exifAttribute6 = this.mAttributes[i].get("SensorBottomBorder");
        ExifAttribute exifAttribute7 = this.mAttributes[i].get("SensorRightBorder");
        if (exifAttribute3 != null) {
            if (exifAttribute3.format == 5) {
                Rational[] rationalArr = (Rational[]) exifAttribute3.getValue(this.mExifByteOrder);
                if (rationalArr == null || rationalArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(rationalArr));
                    return;
                }
                exifAttribute2 = ExifAttribute.createURational(rationalArr[0], this.mExifByteOrder);
                exifAttribute = ExifAttribute.createURational(rationalArr[1], this.mExifByteOrder);
            } else {
                int[] iArr = (int[]) exifAttribute3.getValue(this.mExifByteOrder);
                if (iArr == null || iArr.length != 2) {
                    Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                    return;
                }
                exifAttribute2 = ExifAttribute.createUShort(iArr[0], this.mExifByteOrder);
                exifAttribute = ExifAttribute.createUShort(iArr[1], this.mExifByteOrder);
            }
            this.mAttributes[i].put("ImageWidth", exifAttribute2);
            this.mAttributes[i].put("ImageLength", exifAttribute);
        } else if (exifAttribute4 == null || exifAttribute5 == null || exifAttribute6 == null || exifAttribute7 == null) {
            retrieveJpegImageSize(byteOrderedDataInputStream, i);
        } else {
            int intValue = exifAttribute4.getIntValue(this.mExifByteOrder);
            int intValue2 = exifAttribute6.getIntValue(this.mExifByteOrder);
            int intValue3 = exifAttribute7.getIntValue(this.mExifByteOrder);
            int intValue4 = exifAttribute5.getIntValue(this.mExifByteOrder);
            if (intValue2 > intValue && intValue3 > intValue4) {
                ExifAttribute createUShort = ExifAttribute.createUShort(intValue2 - intValue, this.mExifByteOrder);
                ExifAttribute createUShort2 = ExifAttribute.createUShort(intValue3 - intValue4, this.mExifByteOrder);
                this.mAttributes[i].put("ImageLength", createUShort);
                this.mAttributes[i].put("ImageWidth", createUShort2);
            }
        }
    }

    private int writeExifSegment(ByteOrderedDataOutputStream byteOrderedDataOutputStream, int i) throws IOException {
        ExifTag[][] exifTagArr = EXIF_TAGS;
        int[] iArr = new int[exifTagArr.length];
        int[] iArr2 = new int[exifTagArr.length];
        for (ExifTag exifTag : EXIF_POINTER_TAGS) {
            removeAttribute(exifTag.name);
        }
        removeAttribute(JPEG_INTERCHANGE_FORMAT_TAG.name);
        removeAttribute(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name);
        for (int i2 = 0; i2 < EXIF_TAGS.length; i2++) {
            for (Object obj : this.mAttributes[i2].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.mAttributes[i2].remove(entry.getKey());
                }
            }
        }
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong(0, this.mExifByteOrder));
        }
        if (this.mHasThumbnail) {
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong(0, this.mExifByteOrder));
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_LENGTH_TAG.name, ExifAttribute.createULong((long) this.mThumbnailLength, this.mExifByteOrder));
        }
        for (int i3 = 0; i3 < EXIF_TAGS.length; i3++) {
            int i4 = 0;
            for (Map.Entry<String, ExifAttribute> entry2 : this.mAttributes[i3].entrySet()) {
                int size = entry2.getValue().size();
                if (size > 4) {
                    i4 += size;
                }
            }
            iArr2[i3] = iArr2[i3] + i4;
        }
        int i5 = 8;
        for (int i6 = 0; i6 < EXIF_TAGS.length; i6++) {
            if (!this.mAttributes[i6].isEmpty()) {
                iArr[i6] = i5;
                i5 += (this.mAttributes[i6].size() * 12) + 2 + 4 + iArr2[i6];
            }
        }
        if (this.mHasThumbnail) {
            this.mAttributes[4].put(JPEG_INTERCHANGE_FORMAT_TAG.name, ExifAttribute.createULong((long) i5, this.mExifByteOrder));
            this.mThumbnailOffset = i + i5;
            i5 += this.mThumbnailLength;
        }
        int i7 = i5 + 8;
        if (!this.mAttributes[1].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[1].name, ExifAttribute.createULong((long) iArr[1], this.mExifByteOrder));
        }
        if (!this.mAttributes[2].isEmpty()) {
            this.mAttributes[0].put(EXIF_POINTER_TAGS[2].name, ExifAttribute.createULong((long) iArr[2], this.mExifByteOrder));
        }
        if (!this.mAttributes[3].isEmpty()) {
            this.mAttributes[1].put(EXIF_POINTER_TAGS[3].name, ExifAttribute.createULong((long) iArr[3], this.mExifByteOrder));
        }
        byteOrderedDataOutputStream.writeUnsignedShort(i7);
        byteOrderedDataOutputStream.write(IDENTIFIER_EXIF_APP1);
        byteOrderedDataOutputStream.writeShort(this.mExifByteOrder == ByteOrder.BIG_ENDIAN ? (short) 19789 : 18761);
        byteOrderedDataOutputStream.setByteOrder(this.mExifByteOrder);
        byteOrderedDataOutputStream.writeUnsignedShort(42);
        byteOrderedDataOutputStream.writeUnsignedInt(8);
        for (int i8 = 0; i8 < EXIF_TAGS.length; i8++) {
            if (!this.mAttributes[i8].isEmpty()) {
                byteOrderedDataOutputStream.writeUnsignedShort(this.mAttributes[i8].size());
                int size2 = iArr[i8] + 2 + (this.mAttributes[i8].size() * 12) + 4;
                for (Map.Entry<String, ExifAttribute> entry3 : this.mAttributes[i8].entrySet()) {
                    int i9 = sExifTagMapsForWriting[i8].get(entry3.getKey()).number;
                    ExifAttribute value = entry3.getValue();
                    int size3 = value.size();
                    byteOrderedDataOutputStream.writeUnsignedShort(i9);
                    byteOrderedDataOutputStream.writeUnsignedShort(value.format);
                    byteOrderedDataOutputStream.writeInt(value.numberOfComponents);
                    if (size3 > 4) {
                        byteOrderedDataOutputStream.writeUnsignedInt((long) size2);
                        size2 += size3;
                    } else {
                        byteOrderedDataOutputStream.write(value.bytes);
                        if (size3 < 4) {
                            while (size3 < 4) {
                                byteOrderedDataOutputStream.writeByte(0);
                                size3++;
                            }
                        }
                    }
                }
                if (i8 != 0 || this.mAttributes[4].isEmpty()) {
                    byteOrderedDataOutputStream.writeUnsignedInt(0);
                } else {
                    byteOrderedDataOutputStream.writeUnsignedInt((long) iArr[4]);
                }
                for (Map.Entry<String, ExifAttribute> entry4 : this.mAttributes[i8].entrySet()) {
                    ExifAttribute value2 = entry4.getValue();
                    if (value2.bytes.length > 4) {
                        byteOrderedDataOutputStream.write(value2.bytes, 0, value2.bytes.length);
                    }
                }
            }
        }
        if (this.mHasThumbnail) {
            byteOrderedDataOutputStream.write(getThumbnailBytes());
        }
        byteOrderedDataOutputStream.setByteOrder(ByteOrder.BIG_ENDIAN);
        return i7;
    }

    private static Pair<Integer, Integer> guessDataFormat(String str) {
        int i;
        if (str.contains(",")) {
            String[] split = str.split(",", -1);
            Pair<Integer, Integer> guessDataFormat = guessDataFormat(split[0]);
            if (((Integer) guessDataFormat.first).intValue() == 2) {
                return guessDataFormat;
            }
            for (int i2 = 1; i2 < split.length; i2++) {
                Pair<Integer, Integer> guessDataFormat2 = guessDataFormat(split[i2]);
                if (((Integer) guessDataFormat2.first).equals(guessDataFormat.first) || ((Integer) guessDataFormat2.second).equals(guessDataFormat.first)) {
                    i = ((Integer) guessDataFormat.first).intValue();
                } else {
                    i = -1;
                }
                int intValue = (((Integer) guessDataFormat.second).intValue() == -1 || (!((Integer) guessDataFormat2.first).equals(guessDataFormat.second) && !((Integer) guessDataFormat2.second).equals(guessDataFormat.second))) ? -1 : ((Integer) guessDataFormat.second).intValue();
                if (i == -1 && intValue == -1) {
                    return new Pair<>(2, -1);
                }
                if (i == -1) {
                    guessDataFormat = new Pair<>(Integer.valueOf(intValue), -1);
                } else if (intValue == -1) {
                    guessDataFormat = new Pair<>(Integer.valueOf(i), -1);
                }
            }
            return guessDataFormat;
        } else if (str.contains("/")) {
            String[] split2 = str.split("/", -1);
            if (split2.length == 2) {
                try {
                    long parseDouble = (long) Double.parseDouble(split2[0]);
                    long parseDouble2 = (long) Double.parseDouble(split2[1]);
                    if (parseDouble >= 0) {
                        if (parseDouble2 >= 0) {
                            if (parseDouble <= 2147483647L) {
                                if (parseDouble2 <= 2147483647L) {
                                    return new Pair<>(10, 5);
                                }
                            }
                            return new Pair<>(5, -1);
                        }
                    }
                    return new Pair<>(10, -1);
                } catch (NumberFormatException unused) {
                }
            }
            return new Pair<>(2, -1);
        } else {
            try {
                Long valueOf = Long.valueOf(Long.parseLong(str));
                if (valueOf.longValue() >= 0 && valueOf.longValue() <= 65535) {
                    return new Pair<>(3, 4);
                }
                if (valueOf.longValue() < 0) {
                    return new Pair<>(9, -1);
                }
                return new Pair<>(4, -1);
            } catch (NumberFormatException unused2) {
                try {
                    Double.parseDouble(str);
                    return new Pair<>(12, -1);
                } catch (NumberFormatException unused3) {
                    return new Pair<>(2, -1);
                }
            }
        }
    }

    private static class ByteOrderedDataInputStream extends InputStream implements DataInput {
        private static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        private static final ByteOrder LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        private ByteOrder mByteOrder;
        private DataInputStream mDataInputStream;
        final int mLength;
        int mPosition;

        public ByteOrderedDataInputStream(InputStream inputStream) throws IOException {
            this.mByteOrder = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.mDataInputStream = dataInputStream;
            int available = dataInputStream.available();
            this.mLength = available;
            this.mPosition = 0;
            this.mDataInputStream.mark(available);
        }

        public ByteOrderedDataInputStream(byte[] bArr) throws IOException {
            this(new ByteArrayInputStream(bArr));
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        public void seek(long j) throws IOException {
            int i = this.mPosition;
            if (((long) i) > j) {
                this.mPosition = 0;
                this.mDataInputStream.reset();
                this.mDataInputStream.mark(this.mLength);
            } else {
                j -= (long) i;
            }
            int i2 = (int) j;
            if (skipBytes(i2) != i2) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        public int peek() {
            return this.mPosition;
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return this.mDataInputStream.available();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = this.mDataInputStream.read(bArr, i, i2);
            this.mPosition += read;
            return read;
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public String readLine() throws IOException {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public boolean readBoolean() throws IOException {
            this.mPosition++;
            return this.mDataInputStream.readBoolean();
        }

        @Override // java.io.DataInput
        public char readChar() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readChar();
        }

        @Override // java.io.DataInput
        public String readUTF() throws IOException {
            this.mPosition += 2;
            return this.mDataInputStream.readUTF();
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.mPosition + i2;
            this.mPosition = i3;
            if (i3 > this.mLength) {
                throw new EOFException();
            } else if (this.mDataInputStream.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            int length = this.mPosition + bArr.length;
            this.mPosition = length;
            if (length > this.mLength) {
                throw new EOFException();
            } else if (this.mDataInputStream.read(bArr, 0, bArr.length) != bArr.length) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int i = this.mPosition + 1;
            this.mPosition = i;
            if (i <= this.mLength) {
                int read = this.mDataInputStream.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int i = this.mPosition + 2;
            this.mPosition = i;
            if (i <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (short) ((read << 8) + read2);
                    }
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int i = this.mPosition + 4;
            this.mPosition = i;
            if (i <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                int read3 = this.mDataInputStream.read();
                int read4 = this.mDataInputStream.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) throws IOException {
            int min = Math.min(i, this.mLength - this.mPosition);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.mDataInputStream.skipBytes(min - i2);
            }
            this.mPosition += i2;
            return i2;
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int i = this.mPosition + 2;
            this.mPosition = i;
            if (i <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (read << 8) + read2;
                    }
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        public long readUnsignedInt() throws IOException {
            return ((long) readInt()) & 4294967295L;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            int i = this.mPosition + 8;
            this.mPosition = i;
            if (i <= this.mLength) {
                int read = this.mDataInputStream.read();
                int read2 = this.mDataInputStream.read();
                int read3 = this.mDataInputStream.read();
                int read4 = this.mDataInputStream.read();
                int read5 = this.mDataInputStream.read();
                int read6 = this.mDataInputStream.read();
                int read7 = this.mDataInputStream.read();
                int read8 = this.mDataInputStream.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.mByteOrder;
                    if (byteOrder == LITTLE_ENDIAN) {
                        return (((long) read8) << 56) + (((long) read7) << 48) + (((long) read6) << 40) + (((long) read5) << 32) + (((long) read4) << 24) + (((long) read3) << 16) + (((long) read2) << 8) + ((long) read);
                    }
                    if (byteOrder == BIG_ENDIAN) {
                        return (((long) read) << 56) + (((long) read2) << 48) + (((long) read3) << 40) + (((long) read4) << 32) + (((long) read5) << 24) + (((long) read6) << 16) + (((long) read7) << 8) + ((long) read8);
                    }
                    throw new IOException("Invalid byte order: " + this.mByteOrder);
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public float readFloat() throws IOException {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public double readDouble() throws IOException {
            return Double.longBitsToDouble(readLong());
        }
    }

    private static class ByteOrderedDataOutputStream extends FilterOutputStream {
        private ByteOrder mByteOrder;
        private final OutputStream mOutputStream;

        public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.mOutputStream = outputStream;
            this.mByteOrder = byteOrder;
        }

        public void setByteOrder(ByteOrder byteOrder) {
            this.mByteOrder = byteOrder;
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.mOutputStream.write(bArr);
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.mOutputStream.write(bArr, i, i2);
        }

        public void writeByte(int i) throws IOException {
            this.mOutputStream.write(i);
        }

        public void writeShort(short s) throws IOException {
            if (this.mByteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write((s >>> 0) & 255);
                this.mOutputStream.write((s >>> 8) & 255);
            } else if (this.mByteOrder == ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((s >>> 8) & 255);
                this.mOutputStream.write((s >>> 0) & 255);
            }
        }

        public void writeInt(int i) throws IOException {
            if (this.mByteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.mOutputStream.write((i >>> 0) & 255);
                this.mOutputStream.write((i >>> 8) & 255);
                this.mOutputStream.write((i >>> 16) & 255);
                this.mOutputStream.write((i >>> 24) & 255);
            } else if (this.mByteOrder == ByteOrder.BIG_ENDIAN) {
                this.mOutputStream.write((i >>> 24) & 255);
                this.mOutputStream.write((i >>> 16) & 255);
                this.mOutputStream.write((i >>> 8) & 255);
                this.mOutputStream.write((i >>> 0) & 255);
            }
        }

        public void writeUnsignedShort(int i) throws IOException {
            writeShort((short) i);
        }

        public void writeUnsignedInt(long j) throws IOException {
            writeInt((int) j);
        }
    }

    private void swapBasedOnImageSize(int i, int i2) throws IOException {
        if (!this.mAttributes[i].isEmpty() && !this.mAttributes[i2].isEmpty()) {
            ExifAttribute exifAttribute = this.mAttributes[i].get("ImageLength");
            ExifAttribute exifAttribute2 = this.mAttributes[i].get("ImageWidth");
            ExifAttribute exifAttribute3 = this.mAttributes[i2].get("ImageLength");
            ExifAttribute exifAttribute4 = this.mAttributes[i2].get("ImageWidth");
            if (exifAttribute != null && exifAttribute2 != null && exifAttribute3 != null && exifAttribute4 != null) {
                int intValue = exifAttribute.getIntValue(this.mExifByteOrder);
                int intValue2 = exifAttribute2.getIntValue(this.mExifByteOrder);
                int intValue3 = exifAttribute3.getIntValue(this.mExifByteOrder);
                int intValue4 = exifAttribute4.getIntValue(this.mExifByteOrder);
                if (intValue < intValue3 && intValue2 < intValue4) {
                    HashMap<String, ExifAttribute>[] hashMapArr = this.mAttributes;
                    HashMap<String, ExifAttribute> hashMap = hashMapArr[i];
                    hashMapArr[i] = hashMapArr[i2];
                    hashMapArr[i2] = hashMap;
                }
            }
        }
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    private static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i;
            }
            i += read;
            outputStream.write(bArr, 0, read);
        }
    }

    private static long[] convertToLongArray(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                jArr[i] = (long) iArr[i];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }
}
